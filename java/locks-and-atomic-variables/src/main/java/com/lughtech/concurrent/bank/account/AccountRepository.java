package com.lughtech.concurrent.bank.account;

import java.util.*;

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

    public List<UUID> getAllAccountIds() {
        return accounts.keySet().stream().toList();
    }
}
