package com.lughtech.concurrent.bank.account;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccountRepository {

    private final Map<UUID, BankAccount> accounts;

    public AccountRepository() {
        this.accounts = new HashMap<>();
    }

    public void saveAccount(BankAccount account) {
        this.accounts.put(account.getId(), account);
    }

    public BankAccount getAccountById(UUID id) {
        return this.accounts.get(id);
    }
}
