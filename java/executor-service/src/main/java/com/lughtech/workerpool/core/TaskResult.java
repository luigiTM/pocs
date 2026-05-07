package com.lughtech.workerpool.core;

import java.util.UUID;

public record TaskResult(UUID taskId, boolean success, long executionTime) {
}
