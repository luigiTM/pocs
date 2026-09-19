package com.lughtech.graphqlapi.fetchers;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lughtech.graphqlapi.model.Product;

@Component
public class ProductFetcher {

    private static final Logger log = LoggerFactory.getLogger(ProductFetcher.class);
    private static final String URL = "http://localhost:8094/api/v1/product";

    private final RestTemplate restTemplate;

    public ProductFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product fetchProductById(UUID id) {
        String requestUrl = URL + "/" + id;
        long start = System.nanoTime();
        log.debug("Calling product-service: method=GET, url={}", requestUrl);

        try {
            var response = restTemplate.getForEntity(requestUrl, Product.class);
            log.info("product-service call completed: productId={}, status={}, found={}, durationMs={}",
                    id,
                    response.getStatusCode(),
                    response.hasBody(),
                    elapsedMilliseconds(start));
            return response.getBody();
        } catch (RuntimeException exception) {
            log.error("product-service call failed: productId={}, durationMs={}",
                    id,
                    elapsedMilliseconds(start),
                    exception);
            throw exception;
        }
    }

    private long elapsedMilliseconds(long start) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }
}
