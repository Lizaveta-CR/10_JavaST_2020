package com.company;

public class RunnablePerson extends Person implements Runnable {


    public RunnablePerson(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello - " + getName());
        }
    }
}
