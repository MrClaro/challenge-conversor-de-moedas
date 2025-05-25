package br.com.challenge.one;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import br.com.challenge.one.api.clients.ApiClient;
import br.com.challenge.one.api.configs.ApiConfig;
import br.com.challenge.one.api.exceptions.ApiException;
import br.com.challenge.one.client.Menu;
import br.com.challenge.one.models.ConversionHistoryEntry;
import br.com.challenge.one.models.CurrencyConversionResponse;
import br.com.challenge.one.util.gson.LocalDateTimeAdapter;

public class Main {
  public static void main(String[] args) {
    ApiClient apiClient = ApiConfig.getInstance();
    Menu menu = new Menu();
    Scanner scan = new Scanner(System.in);
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
        .setPrettyPrinting()
        .create();

    while (true) {
      menu.showMenu();
      int option;
      try {
        option = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida. Por favor, digite um número.");
        scan.nextLine();
        continue;
      }
      scan.nextLine();

      switch (option) {
        case 1:
          menu.showConversionOptions();
          int sourceOption;
          try {
            sourceOption = scan.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("Opção de moeda inválida. Por favor, digite um número.");
            scan.nextLine();
            continue;
          }
          scan.nextLine();

          if (sourceOption == 6) {
            continue;
          }

          String sourceCurrency = menu.getCurrencyByOption(sourceOption);
          if (sourceCurrency == null) {
            System.out.println("Opção de moeda de origem inválida. Tente novamente.");
            continue;
          }

          menu.showConversionTargetOptions();
          int targetOption;
          try {
            targetOption = scan.nextInt();
          } catch (InputMismatchException e) {
            System.out.println("Opção de moeda inválida. Por favor, digite um número.");
            scan.nextLine();
            continue;
          }
          scan.nextLine();

          if (targetOption == 6) {
            continue;
          }

          String targetCurrency = menu.getCurrencyByOption(targetOption);
          if (targetCurrency == null) {
            System.out.println("Opção de moeda de destino inválida. Tente novamente.");
            continue;
          }

          if (sourceCurrency.equals(targetCurrency)) {
            System.out.println("A moeda de origem e destino não podem ser iguais. Tente novamente.");
            continue;
          }

          Menu.showConversionAmountPrompt();
          double amount;
          if (scan.hasNextDouble()) {
            amount = scan.nextDouble();
            scan.nextLine();
            if (amount <= 0) {
              System.out.println("O valor para conversão deve ser positivo.");
              continue;
            }
          } else {
            System.out.println("Valor inválido. Por favor, insira um número.");
            scan.nextLine();
            continue;
          }

          System.out.println(
              "Convertendo de " + sourceCurrency + " para " + targetCurrency + " o valor de " + amount + "...");

          try {
            String jsonResponse = apiClient.get(sourceCurrency, targetCurrency, amount);
            CurrencyConversionResponse apiResponse = gson.fromJson(jsonResponse, CurrencyConversionResponse.class);

            if (apiResponse == null) {
              Menu.showError("Não foi possível processar a resposta da API (objeto nulo). Verifique o JSON retornado.");
              System.out.println("JSON Recebido: " + jsonResponse);
              continue;
            }

            if ("success".equalsIgnoreCase(apiResponse.getResultStatus())) {
              double finalConvertedAmount = apiResponse.getConversionResult();
              String resultMessage = String.format("%.2f %s equivalem a %.3f %s.",
                  amount,
                  sourceCurrency,
                  finalConvertedAmount,
                  targetCurrency);
              if (apiResponse.getConversionRate() > 0) {
                resultMessage += String.format(" (Taxa: 1 %s = %.4f %s)",
                    sourceCurrency, apiResponse.getConversionRate(), targetCurrency);
              }
              Menu.showConversionResult(resultMessage);
              try {
                ConversionHistoryEntry historicoEntry = new ConversionHistoryEntry();
                historicoEntry.setDataHora(java.time.LocalDateTime.now());
                historicoEntry.setMoedaOrigem(sourceCurrency);
                historicoEntry.setValorOriginal(amount);
                historicoEntry.setMoedaDestino(targetCurrency);
                historicoEntry.setValorConvertido(finalConvertedAmount);
                historicoEntry.setTaxaConversao(apiResponse.getConversionRate());

                List<ConversionHistoryEntry> todasAsConversoes = new ArrayList<>();
                File arquivoHistorico = new File("conversion_history.json");

                if (arquivoHistorico.exists() && arquivoHistorico.length() > 0) {
                  try (FileReader reader = new FileReader(arquivoHistorico)) {
                    Type tipoLista = new TypeToken<ArrayList<ConversionHistoryEntry>>() {
                    }.getType();
                    todasAsConversoes = gson.fromJson(reader, tipoLista);
                    if (todasAsConversoes == null) {
                      todasAsConversoes = new ArrayList<>();
                    }
                  } catch (IOException | JsonSyntaxException e) {
                    Menu.showError("Erro ao ler histórico existente: " + e.getMessage());
                    todasAsConversoes = new ArrayList<>();
                  }
                }

                todasAsConversoes.add(historicoEntry);

                try (FileWriter writer = new FileWriter(arquivoHistorico)) {
                  gson.toJson(todasAsConversoes, writer);
                  System.out.println("Histórico de conversões atualizado em: conversion_history.json");
                } catch (IOException e) {
                  Menu.showError("Erro ao salvar o histórico atualizado: " + e.getMessage());
                }
              } catch (Exception e) {
                Menu.showError("Erro ao preparar dados para o histórico: " + e.getMessage());
                e.printStackTrace();
              }
            } else {
              String errorMessage = "A API de conversão retornou um status não esperado.";
              if (apiResponse.getResultStatus() != null) {
                errorMessage += " Status: " + apiResponse.getResultStatus();
              }
              Menu.showError(errorMessage);
            }

          } catch (ApiException e) {
            Menu.showError("Erro na comunicação com a API: " + e.getMessage());
          } catch (JsonSyntaxException e) {
            Menu.showError("Erro ao processar a resposta da API (formato JSON inválido): " + e.getMessage());
          } catch (Exception e) {
            Menu.showError("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace();
          }
          break;
        case 2:
          menu.exit();
          scan.close();
          return;
        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }
}
