package by.tsvirko;

public class ThreadToDisable implements Runnable {
    private boolean isActive;

    void disable() {
        isActive = false;
    }

    public ThreadToDisable() {
        isActive = true;
    }

    @Override
    public void run() {
        System.out.printf("Thread %s started work...\n", Thread.currentThread().getName());
        int counter = 1;//счетчик циклов
        while (isActive) {
            System.out.printf("Cycle " + counter++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
        System.out.printf("Thread %s finished work...\n", Thread.currentThread().getName());
    }
}
