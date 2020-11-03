package by.tsvirko.atomic;

import java.util.concurrent.TimeUnit;

public class Broker extends Thread {
    private Market market;
    private static final int PAUSE = 500;

    public Broker(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Current index: " + market.getIndex());
                TimeUnit.MILLISECONDS.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
