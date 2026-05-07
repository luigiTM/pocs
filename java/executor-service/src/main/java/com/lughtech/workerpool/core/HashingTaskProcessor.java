package com.lughtech.workerpool.core;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingTaskProcessor implements TaskProcessor {

    @Override
    public TaskResult process(Task task) {
        long start = System.nanoTime();

        try {
            String input = task.payload();
            // Variabilidade determinística baseada no UUID
            int iterations = ((Math.abs(task.id().hashCode()) % 10) + 1) * 1000;
            String result = input;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            for (int i = 0; i < iterations; i++) {
                byte[] hash = digest.digest(result.getBytes(StandardCharsets.UTF_8));
                result = bytesToHex(hash);
            }
            long duration = System.nanoTime() - start;
            return new TaskResult(task.id(), true, duration);

        } catch (NoSuchAlgorithmException e) {
            long duration = System.nanoTime() - start;
            return new TaskResult(task.id(), false, duration);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString();
    }
}