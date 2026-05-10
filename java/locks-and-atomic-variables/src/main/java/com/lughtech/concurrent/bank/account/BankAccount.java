package com.lughtech.concurrent.bank.account;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private UUID id;
    private long balance;
    private Lock lock;

    public BankAccount() {
        this.id = UUID.randomUUID();
        this.balance = 5000;
        this.lock = new ReentrantLock();
    }

    public UUID getId() {
        return this.id;
    }

    public Lock getLock() {
        return lock;
    }

    public long deposit(long amount) {
        this.balance += amount;
        return this.balance;
    }

    public long withdraw(long amount) {
        if (balance > amount) {
            this.balance -= amount;
            return amount;
        }
        throw new RuntimeException("Insufficient balance");
    }
}
