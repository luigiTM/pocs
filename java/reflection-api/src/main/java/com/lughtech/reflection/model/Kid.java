package com.lughtech.reflection.model;

import com.lughtech.reflection.actions.Playing;

public class Kid extends Person implements Playing {

    public Kid(String name, int age) {
        super(name, age);
    }

    @Override
    public void play() {
        System.out.println("Playing with video games!");
    }

    @Override
    public boolean needsToWork() {
        return false;
    }
}
