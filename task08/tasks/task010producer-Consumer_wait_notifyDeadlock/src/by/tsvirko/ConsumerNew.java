package by.tsvirko;

public class ConsumerNew extends Thread {
    StoreNew store;

    ConsumerNew(StoreNew store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }

}
