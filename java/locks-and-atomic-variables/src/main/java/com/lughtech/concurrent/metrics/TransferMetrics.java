package com.lughtech.concurrent.metrics;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TransferMetrics {

    private final AtomicInteger successfulTransfers;
    private final AtomicInteger failedTransfers;
    private final AtomicLong transferredAmount;

    public TransferMetrics() {
        successfulTransfers = new AtomicInteger(0);
        failedTransfers = new AtomicInteger(0);
        transferredAmount = new AtomicLong(0);
    }

    public void incrementSuccessfulTransfers() {
        successfulTransfers.incrementAndGet();
    }

    public void incrementFailedTransfers() {
        this.failedTransfers.incrementAndGet();
    }

    public void incrementTransferredAmount(long amount) {
        this.transferredAmount.getAndAdd(amount);
    }

    @Override
    public String toString() {
        return "Successful transfers: " + this.successfulTransfers + ", Failed transfer: " + this.failedTransfers + ", Transferred amount: " + this.transferredAmount;
    }
}
