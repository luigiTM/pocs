package com.lughtech.concurrent.bank.transfer;

import com.lughtech.concurrent.bank.account.AccountRepository;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class TransferTask implements Runnable {

    private final TransferService transferService;
    private final AccountRepository accountRepository;

    public TransferTask(TransferService transferService, AccountRepository accountRepository) {
        this.transferService = transferService;
        this.accountRepository = accountRepository;
    }

    @Override
    public void run() {
        List<UUID> ids = this.accountRepository.getAllAccountIds();
        Random random = new Random();
        UUID from = ids.get(random.nextInt(ids.size()));
        UUID to;
        do {
            to = ids.get(random.nextInt(ids.size()));
        } while (from.equals(to));
        this.transferService.transfer(from, to, 500);
    }
}
