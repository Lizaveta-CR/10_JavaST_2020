package by.tsvirko.isActive;

public class RunnerJoin {
    static {
        System.out.println("main start");
    }

    public static void main(String[] args) {
        JoinThread first = new JoinThread("First");
        JoinThread second = new JoinThread("Second");

        first.start();
        second.start();

        try {
            first.join();// поток main остановлен до окончания работы потока first
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
