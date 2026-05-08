package com.lughtech.aggregator.core;

public record AggregatedResponse(int totalRequests, int successCount, int failureCount, long totalTime) {
}
