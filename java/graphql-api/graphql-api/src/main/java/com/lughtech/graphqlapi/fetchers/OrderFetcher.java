package com.lughtech.graphqlapi.fetchers;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lughtech.graphqlapi.model.Order;

@Component 
public class OrderFetcher {

    private static final Logger log = LoggerFactory.getLogger(OrderFetcher.class);
    private static final String URL = "http://localhost:8092/api/v1/order";
    private final RestTemplate restTemplate;

    public OrderFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order fetchOrderById(UUID id) {
        String requestUrl = URL + "/" + id;
        long start = System.nanoTime();
        log.debug("Calling order-service: method=GET, url={}", requestUrl);

        try {
            var response = restTemplate.getForEntity(requestUrl, Order.class);
            log.info("order-service call completed: orderId={}, status={}, found={}, durationMs={}",
                    id,
                    response.getStatusCode(),
                    response.hasBody(),
                    elapsedMilliseconds(start));
            return response.getBody();
        } catch (RuntimeException exception) {
            log.error("order-service call failed: orderId={}, durationMs={}",
                    id,
                    elapsedMilliseconds(start),
                    exception);
            throw exception;
        }
    }

    public List<Order> fetchOrdersByCustomerId(UUID id) {
        String requestUrl = URL + "/customer/" + id;
        long start = System.nanoTime();
        log.debug("Calling order-service: method=GET, url={}", requestUrl);

        try {
            var response = restTemplate.exchange(
                    requestUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Order>>() {
                    });
            List<Order> orders = response.getBody() != null ? response.getBody() : List.of();
            log.info("order-service call completed: customerId={}, status={}, orderCount={}, durationMs={}",
                    id,
                    response.getStatusCode(),
                    orders.size(),
                    elapsedMilliseconds(start));
            return orders;
        } catch (RuntimeException exception) {
            log.error("order-service call failed: customerId={}, durationMs={}",
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
