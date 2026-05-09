package com.lughtech.concurrent.metrics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransferMetrics {

    private AtomicInteger successfulTransfers;
    private AtomicInteger failedTransfers;
    private AtomicLong transferredAmount;

}
