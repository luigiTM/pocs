package com.lughtech.httpclient;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    static void main() throws URISyntaxException, IOException, InterruptedException {
        var cepFetcher = new CepFetcher();
        var cepInformation = cepFetcher.fetchCepInformation("88080250");
        System.out.println(cepInformation);
    }
}
