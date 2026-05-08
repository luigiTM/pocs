package com.lughtech.aggregator.api;

import com.lughtech.aggregator.core.ApiResult;

import java.util.concurrent.Callable;

public abstract class ApiTask implements Callable<ApiResult> {

    private final String apiName;
    private final String apiUrl;
    private final HttpClientProvider httpClientProvider = new HttpClientProvider();

    public ApiTask(String apiName, String apiUrl) {
        this.apiName = apiName;
        this.apiUrl = apiUrl;
    }

    @Override
    public ApiResult call() {
        long start = System.currentTimeMillis();
        try {
            var response = httpClientProvider.makeRequest(apiUrl);
            if (response.statusCode() > 200 && response.statusCode() < 300) {
                return new ApiResult(apiName, true, response.statusCode(), response.body(), (System.currentTimeMillis() - start), null);
            }
            return new ApiResult(apiName, false, response.statusCode(), response.body(), (System.currentTimeMillis() - start), null);
        } catch (Exception e) {
            return new ApiResult(apiName, false, 500, null, (System.currentTimeMillis() - start), e.getMessage());
        }
    }

}
