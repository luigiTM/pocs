package com.lughtech.aggregator.core;

import com.lughtech.aggregator.api.ApiTask;
import com.lughtech.aggregator.api.RandomUserApiTask;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AggregatorServiceTest {

    private AggregatorService aggregatorService;

    @Mock
    private ApiTask apiTask;

    @Mock
    private ApiTask anotherApiTask;

    @Test
    void shouldReturnResultWithSuccessWhenApiTaskSucceeds() {
        apiTask = mock(RandomUserApiTask.class);
        when(apiTask.call())
                .thenReturn(new ApiResult("Test API", true, 200, "body: { OK }", 100, null));
        List<ApiTask> tasks = Collections.singletonList(apiTask);
        aggregatorService = new AggregatorService(1);
        var result = aggregatorService.doTasks(tasks);
        aggregatorService.stop();

        assertEquals(1, result.totalRequests());
        assertEquals(1, result.successCount());
        assertEquals(0, result.failureCount());
        assertFalse(result.responses().isEmpty());
        assertEquals(1, result.responses().size());
        assertEquals("body: { OK }", result.responses().getFirst());
    }

    @Test
    void shouldReturnResultWithFailureWhenApiTaskFails() {
        apiTask = mock(RandomUserApiTask.class);
        when(apiTask.call())
                .thenReturn(new ApiResult("Test API", false, 500, null, 100, "Error"));
        List<ApiTask> tasks = Collections.singletonList(apiTask);
        aggregatorService = new AggregatorService(1);
        var result = aggregatorService.doTasks(tasks);
        aggregatorService.stop();

        assertEquals(1, result.totalRequests());
        assertEquals(0, result.successCount());
        assertEquals(1, result.failureCount());
        assertFalse(result.responses().isEmpty());
        assertEquals(1, result.responses().size());
        assertEquals("Error", result.responses().getFirst());
    }

    @Test
    void shouldReturnResultWithSuccessWhenTwoApiTasksSucceed() {
        apiTask = mock(RandomUserApiTask.class);
        anotherApiTask = mock(RandomUserApiTask.class);
        when(apiTask.call())
                .thenReturn(new ApiResult("Test API", true, 200, "body: { OK }", 100, null));
        when(anotherApiTask.call())
                .thenReturn(new ApiResult("Test API", true, 200, "body: { OK }", 100, null));
        List<ApiTask> tasks = Arrays.asList(apiTask, anotherApiTask);
        aggregatorService = new AggregatorService(1);
        var result = aggregatorService.doTasks(tasks);
        aggregatorService.stop();

        assertEquals(2, result.totalRequests());
        assertEquals(2, result.successCount());
        assertEquals(0, result.failureCount());
        assertFalse(result.responses().isEmpty());
        assertEquals(2, result.responses().size());
        assertEquals("body: { OK }", result.responses().getFirst());
        assertEquals("body: { OK }", result.responses().get(1));
    }

    @Test
    void shouldReturnResultWithSuccessAndFailureWhenTwoApiTasksSucceedAndFail() {
        apiTask = mock(RandomUserApiTask.class);
        anotherApiTask = mock(RandomUserApiTask.class);
        when(apiTask.call())
                .thenReturn(new ApiResult("Test API", true, 200, "body: { OK }", 100, null));
        when(anotherApiTask.call())
                .thenReturn(new ApiResult("Test API", false, 500, null, 100, "Error"));
        List<ApiTask> tasks = Arrays.asList(apiTask, anotherApiTask);
        aggregatorService = new AggregatorService(1);
        var result = aggregatorService.doTasks(tasks);
        aggregatorService.stop();

        assertEquals(2, result.totalRequests());
        assertEquals(1, result.successCount());
        assertEquals(1, result.failureCount());
        assertFalse(result.responses().isEmpty());
        assertEquals(2, result.responses().size());
        assertEquals("body: { OK }", result.responses().getFirst());
        assertEquals("Error", result.responses().get(1));
    }
}
