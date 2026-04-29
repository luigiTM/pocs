package com.lughtech.reflection.model;

public class Adult extends Person{

    private boolean isWorking;

    public Adult() {
        super("John Doe", 30);
        isWorking = false;
    }

    public Adult(int age) {
        super("John Doe", age);
        isWorking = false;
    }

    public Adult(String name, int age) {
        super(name, age);
        isWorking = false;
    }

    public void setWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public boolean isWorking() {
     return this.isWorking;
    }

    @Override
    public boolean needsToWork() {
        return true;
    }
}
