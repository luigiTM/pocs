package com.lughtech.concurrent.execution;

import com.lughtech.concurrent.bank.account.AccountRepository;
import com.lughtech.concurrent.bank.account.BankAccount;
import com.lughtech.concurrent.bank.transfer.TransferService;
import com.lughtech.concurrent.bank.transfer.TransferTask;
import com.lughtech.concurrent.metrics.TransferMetrics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferRunner {

    private final AccountRepository accountRepository;
    private final TransferService transferService;
    private final TransferMetrics transferMetrics;

    public TransferRunner() {
        this.accountRepository = new AccountRepository();
        this.transferMetrics = new TransferMetrics();
        this.transferService = new TransferService(this.accountRepository, transferMetrics);
    }

    public void runTransfers(int workers, int transfers) throws InterruptedException {
        createAccounts(50);
        try(ExecutorService executorService = Executors.newFixedThreadPool(workers)) {
            for (int i = 0; i < transfers; i++) {
                executorService.submit(new TransferTask(transferService, accountRepository));
            }
            executorService.awaitTermination(5, TimeUnit.SECONDS);
            System.out.println(transferMetrics);
        }

    }

    private void createAccounts(int accountToCreate) {
        for (int i = 0; i < accountToCreate; i++) {
            var account = new BankAccount();
            this.accountRepository.saveAccount(account);
        }
    }
}
