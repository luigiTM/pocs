package com.lughtech.reflection.model;

import com.lughtech.reflection.actions.Work;

public abstract class Person implements Work {
    private String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

}
