package com.lughtech.concurrent.bank.transfer;

import com.lughtech.concurrent.bank.account.AccountRepository;
import com.lughtech.concurrent.metrics.TransferMetrics;

import java.util.UUID;

public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferMetrics transferMetrics;

    public TransferService(AccountRepository accountRepository, TransferMetrics transferMetrics) {
        this.accountRepository = accountRepository;
        this.transferMetrics = transferMetrics;
    }

    public void transfer(UUID from, UUID to, long amount) {
        System.out.println("Transferring from " + from + " to " + to + " the amount of " + amount);
        var fromAccount = this.accountRepository.getAccountById(from);
        var toAccount = this.accountRepository.getAccountById(to);
        fromAccount.getLock().lock();
        try {
            toAccount.getLock().lock();
            try {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                transferMetrics.incrementSuccessfulTransfers();
                transferMetrics.incrementTransferredAmount(amount);
            } catch (RuntimeException e) {
                transferMetrics.incrementFailedTransfers();
                System.err.println("Failed to transfer " + amount + " from account " + from + " to " + to);
            } finally {
                toAccount.getLock().unlock();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            fromAccount.getLock().unlock();
        }
    }
}
