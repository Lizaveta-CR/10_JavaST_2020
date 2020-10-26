package com.company;

public class MainPerson {
    public static void main(String[] args) {
        RunnablePerson p1 = new RunnablePerson("First person");
        RunnablePerson p2 = new RunnablePerson("Second person");
        Thread t1 = new Thread(p1);
//        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        Thread t2 = new Thread(p2);
//        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();
    }
}
