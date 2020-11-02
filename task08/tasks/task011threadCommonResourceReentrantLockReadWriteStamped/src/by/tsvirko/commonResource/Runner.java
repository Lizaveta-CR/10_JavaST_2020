package by.tsvirko.commonResource;

import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker = new ReentrantLock();//создаем заглушку
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CountThread(commonResource, locker));
            thread.setName("Thread "+i);
            thread.start();
        }
    }
}
