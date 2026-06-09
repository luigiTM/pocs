package com.lughtech.aggregator.core;

import java.util.List;

public record AggregatedResponse(int totalRequests, int successCount, int failureCount, long totalTime, List<String> responses) {


    public AggregatedResponse(int tasksSize, List<ApiResult> results) {
        this(
                tasksSize,
                Math.toIntExact(results.stream().filter(ApiResult::success).count()),
                Math.toIntExact(results.stream().filter(apiResult -> !apiResult.success()).count()),
                results.stream().map(ApiResult::executionTime).reduce(0L, Long::sum),
                results.stream().map(result -> {
                    if (result.success()) {
                        return result.responseBody();
                    }
                    return result.errorMessage();
                }).toList()
        );
    }
}
