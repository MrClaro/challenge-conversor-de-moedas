package br.com.challenge.one;

import br.com.challenge.one.api.clients.ApiClient;
import br.com.challenge.one.api.configs.ApiConfig;
import br.com.challenge.one.api.exceptions.ApiException;

public class Main {
  public static void main(String[] args) {
    try {
      ApiClient apiClient = ApiConfig.getInstance();
      String teste = apiClient.get("USD", "BRL", 100.0);

      System.out.println("Teste: " + teste);

    } catch (ApiException e) {
      System.err.println("Erro na API: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
