package com.lughtech.aggregator.core;

public record ApiResult(String apiName, boolean success, int statusCode, String responseBody, long executionTime, String errorMessage) {
}
