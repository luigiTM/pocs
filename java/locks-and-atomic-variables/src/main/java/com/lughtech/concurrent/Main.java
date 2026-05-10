package com.lughtech.concurrent;

import com.lughtech.concurrent.execution.TransferRunner;

public class Main {

    static void main() throws InterruptedException {
        var transferRunner = new TransferRunner();
        transferRunner.runTransfers(20, 50);
    }

}
