package br.com.challenge.one.api.configs;

import br.com.challenge.one.api.clients.ApiClient;

public class ApiConfig {
    private static ApiClient instance;

    private ApiConfig() {}

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }
}