package by.tsvirko;

public class ConsumerReentrant implements Runnable {
    StoreReentrant store;

    public ConsumerReentrant(StoreReentrant store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
