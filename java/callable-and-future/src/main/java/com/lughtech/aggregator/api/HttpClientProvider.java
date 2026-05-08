package com.lughtech.aggregator.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientProvider {

    private final HttpClient client;

    public HttpClientProvider() {
        this.client = HttpClient.newBuilder().build();
    }

    public HttpResponse<String> makeRequest(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
