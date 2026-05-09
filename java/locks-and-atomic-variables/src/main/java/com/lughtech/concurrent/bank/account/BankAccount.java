package com.lughtech.concurrent.bank.account;

import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private UUID id;
    private float balance;
    private Lock lock;

    public BankAccount() {
        this.id = UUID.randomUUID();
        this.balance = 0;
        this.lock = new ReentrantLock();
    }

    public UUID getId() {
        return this.id;
    }

    public float deposit(float amount) {
        this.balance += amount;
        return this.balance;
    }

    public float withdraw(float amount) {
        if (balance > amount) {
            this.balance -= amount;
            return amount;
        }
        return 0F;
    }
}
