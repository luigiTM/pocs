package com.lughtech.graphqlapi.fetchers;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lughtech.graphqlapi.model.Payment;

@Component
public class PaymentFetcher {

    private static final Logger log = LoggerFactory.getLogger(PaymentFetcher.class);
    private static final String URL = "http://localhost:8093/api/v1/payment";

    private final RestTemplate restTemplate;

    public PaymentFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment fetchPaymentById(UUID id) {
        return fetchPayment(URL + "/" + id, "paymentId", id);
    }

    public Payment fetchPaymentByOrderId(UUID orderId) {
        return fetchPayment(URL + "/order/" + orderId, "orderId", orderId);
    }

    private Payment fetchPayment(String requestUrl, String identifierName, UUID identifier) {
        long start = System.nanoTime();
        log.debug("Calling payment-service: method=GET, url={}", requestUrl);

        try {
            var response = restTemplate.getForEntity(requestUrl, Payment.class);
            log.info("payment-service call completed: {}={}, status={}, found={}, durationMs={}",
                    identifierName,
                    identifier,
                    response.getStatusCode(),
                    response.hasBody(),
                    elapsedMilliseconds(start));
            return response.getBody();
        } catch (RuntimeException exception) {
            log.error("payment-service call failed: {}={}, durationMs={}",
                    identifierName,
                    identifier,
                    elapsedMilliseconds(start),
                    exception);
            throw exception;
        }
    }

    private long elapsedMilliseconds(long start) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
    }
}
