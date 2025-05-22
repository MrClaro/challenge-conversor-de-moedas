package br.com.challenge.one.client;

public class Menu {
  public static void showMenu() {
    System.out.println("===================================");
    System.out.println("Bem-vindo ao Conversor de Moedas!");
    System.out.println("Escolha uma opção:");
    System.out.println("1. Converter moeda");
    System.out.println("2. Sair");
    System.out.println("===================================");
  }

  public static void showConversionOptions() {
    System.out.println("Escolha a moeda de origem:");
    System.out.println("1. Dólar");
    System.out.println("2. Euro");
    System.out.println("3. Libra");
    System.out.println("4. Iene");
    System.out.println("5. Real");
    System.out.println("6. Voltar");
  }

  public static void showConversionTargetOptions() {
    System.out.println("Escolha a moeda de destino:");
    System.out.println("1. Dólar");
    System.out.println("2. Euro");
    System.out.println("3. Libra");
    System.out.println("4. Iene");
    System.out.println("5. Real");
    System.out.println("6. Voltar");
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
}
