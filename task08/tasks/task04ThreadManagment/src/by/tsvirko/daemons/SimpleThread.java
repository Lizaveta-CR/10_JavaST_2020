package by.tsvirko.daemons;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            if (isDaemon()) {
                System.out.println("Старт потока-демона");
                Thread.sleep(1);
                //10000 - может не успеть завершить
            } else {
                System.out.println("Старт обычного потока");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!isDaemon()) {
                System.out.println("Завершение обычного потока");
            } else {
                System.out.println("Завершение потока-демона");
            }
        }
    }
}
