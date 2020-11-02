package by.tsvirko;

public class ProducerReentrant implements Runnable {
    StoreReentrant store;

    ProducerReentrant(StoreReentrant store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
