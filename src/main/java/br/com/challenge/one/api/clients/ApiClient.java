package br.com.challenge.one.api.clients;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import br.com.challenge.one.api.exceptions.ApiException;
import io.github.cdimascio.dotenv.Dotenv;

public class ApiClient {
  private final String baseUrl;
  private final HttpClient httpClient;

  public ApiClient() {
    Dotenv dotenv = Dotenv.load();
    this.baseUrl = dotenv.get("API_BASE_URL");
    this.httpClient = HttpClient.newBuilder()
        .connectTimeout(Duration.ofSeconds(30))
        .build();
  }

  public String get(String base, String target, Double amount) throws ApiException {
    try {
      Dotenv dotenv = Dotenv.load();
      String token = dotenv.get("API_TOKEN");

      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(buildUrl(token, base, target, amount)))
          .timeout(Duration.ofMinutes(2))
          .header("Accept", "application/json")
          .GET()
          .build();

      HttpResponse<String> response = httpClient.send(
          request, HttpResponse.BodyHandlers.ofString());

      return handleResponse(response);
    } catch (Exception e) {
      throw new ApiException("Erro na requisição GET", e);
    }
  }

  private String buildUrl(String token, String base, String target, Double amount) {
    return baseUrl + token + "/pair/" + base + "/" + target + "/" + amount;

  }

  private String handleResponse(HttpResponse<String> response) throws ApiException {
    if (response.statusCode() >= 200 && response.statusCode() < 300) {
      return response.body();
    } else {
      throw new ApiException("Erro na API: " + response.statusCode() +
          " - " + response.body());
    }
  }
}
