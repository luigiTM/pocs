package com.lughtech.aggregator.core;

import com.lughtech.aggregator.api.ApiTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AggregatorService {

    private final ExecutorService executor;

    public AggregatorService(int workers) {
        this.executor = Executors.newFixedThreadPool(workers);
    }

    public AggregatedResponse doTasks(List<ApiTask> tasks) {
        List<Future<ApiResult>> futures = new ArrayList<>(tasks.size());
        tasks.forEach(task -> {
            var future = this.executor.submit(task);
            futures.add(future);
        });
        List<ApiResult> results = new ArrayList<>(tasks.size());
        futures.forEach(future -> {
            try {
                var result = future.get();
                results.add(result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return new AggregatedResponse(tasks.size(), results);
    }

    public void stop() {
        this.executor.shutdown();
    }
}
