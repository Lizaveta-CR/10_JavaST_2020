package by.tsvirko.task01;

public class ThreadHello extends Thread {
    @Override
    public void run() {
        System.out.println("Hello - " + getName());
    }

    public static void main(String[] args) {
        ThreadHello threadHello = new ThreadHello();
        threadHello.start();
        System.out.println(Thread.currentThread().getName());
    }
}
