package com.lughtech.workerpool;

import com.lughtech.workerpool.execution.WorkerPoolRunner;

public class Main {

    static void main() throws InterruptedException {
        WorkerPoolRunner workerPoolRunner = new WorkerPoolRunner(10, 5);
        workerPoolRunner.produce(1000);
        workerPoolRunner.stop();
    }
}
