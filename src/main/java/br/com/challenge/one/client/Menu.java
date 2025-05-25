package br.com.challenge.one.client;

import java.util.HashMap;
import java.util.Map;

public class Menu {
  private static Map<Integer, String> currencyOptions;

  static {
    currencyOptions = new HashMap<>();
    currencyOptions.put(1, "USD");
    currencyOptions.put(2, "EUR");
    currencyOptions.put(3, "GBP");
    currencyOptions.put(4, "JPY");
    currencyOptions.put(5, "BRL");
    currencyOptions.put(6, "ARS");
    currencyOptions.put(7, "CLP");
    currencyOptions.put(8, "COP");
    currencyOptions.put(9, "BOB");
  }

  public void showMenu() {
    System.out.println("===================================");
    System.out.println("Bem-vindo ao Conversor de Moedas!");
    System.out.println("Escolha uma opção:");
    System.out.println("1. Converter moeda");
    System.out.println("2. Ver histórico de conversões");
    System.out.println("3. Sair");
    System.out.println("===================================");
  }

  public void showConversionOptions() {
    System.out.println("===================================");
    System.out.println("Escolha a moeda de origem:");
    System.out.println("1. Dólar Americano (USD)");
    System.out.println("2. Euro (EUR)");
    System.out.println("3. Libra Esterlina (GBP)");
    System.out.println("4. Iene Japonês (JPY)");
    System.out.println("5. Real Brasileiro (BRL)");
    System.out.println("6. Peso Argentino (ARS)");
    System.out.println("7. Peso Chileno (CLP)");
    System.out.println("8. Peso Colombiano (COP)");
    System.out.println("9. Boliviano Boliviano (BOB)");
    System.out.println("0. Voltar");
    System.out.println("===================================");
  }

  public void showConversionTargetOptions() {
    System.out.println("===================================");
    System.out.println("Escolha a moeda de origem:");
    System.out.println("1. Dólar Americano (USD)");
    System.out.println("2. Euro (EUR)");
    System.out.println("3. Libra Esterlina (GBP)");
    System.out.println("4. Iene Japonês (JPY)");
    System.out.println("5. Real Brasileiro (BRL)");
    System.out.println("6. Peso Argentino (ARS)");
    System.out.println("7. Peso Chileno (CLP)");
    System.out.println("8. Peso Colombiano (COP)");
    System.out.println("9. Boliviano Boliviano (BOB)");
    System.out.println("0. Voltar");
    System.out.println("===================================");
  }

  public String getCurrencyByOption(int option) {
    return currencyOptions.get(option);
  }

  public static void showConversionAmountPrompt() {
    System.out.print("Digite o valor a ser convertido: ");
  }

  public static void showConversionResult(String result) {
    System.out.println("Resultado da conversão: " + result);
  }

  public static void showError(String error) {
    System.err.println("Erro: " + error);
  }

  public void exit() {
    System.out.println("Saindo do programa...");
    System.exit(0);
  }
}
