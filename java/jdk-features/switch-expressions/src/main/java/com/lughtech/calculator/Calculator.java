package com.lughtech.calculator;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

    public Integer calculate(String expression) {
        var splitExpression = StringUtils.splitByCharacterType(expression);
        if(splitExpression.length < 3) {
            throw new RuntimeException("Invalid expression");
        }
        var firstArgument = Integer.parseInt(splitExpression[0]);
        var secondArgument = Integer.parseInt(splitExpression[2]);
        var operation = splitExpression[1];
        return switch (operation) {
            case "+" -> firstArgument + secondArgument;
            case "-" -> firstArgument - secondArgument;
            case "*" -> firstArgument * secondArgument;
            case "/" -> firstArgument / secondArgument;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
    }
}
