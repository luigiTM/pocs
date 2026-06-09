package com.lughtech.aggregator;

import com.lughtech.aggregator.api.CatApiTask;
import com.lughtech.aggregator.api.JokeApiTask;
import com.lughtech.aggregator.api.RandomUserApiTask;
import com.lughtech.aggregator.core.AggregatorService;

import java.util.Arrays;

public class Main {

    static void main() {

        AggregatorService service = new AggregatorService();
        var tasks = Arrays.asList(
                new CatApiTask(),
                new JokeApiTask(),
                new RandomUserApiTask()
        );

        var results = service.doTasks(tasks);
        service.stop();
        System.out.println(results);
    }
}
