package com.lughtech.reflection.model;

public class Adult extends Person{

    public Adult() {
        super("John Doe", 30);
    }

    public Adult(int age) {
        super("John Doe", age);
    }

    public Adult(String name, int age) {
        super(name, age);
    }

    @Override
    public boolean needsToWork() {
        return true;
    }
}
