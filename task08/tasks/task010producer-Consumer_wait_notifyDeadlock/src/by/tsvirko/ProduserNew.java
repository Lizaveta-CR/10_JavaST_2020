package by.tsvirko;

public class ProduserNew extends Thread {
    StoreNew store;

    ProduserNew(StoreNew store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }

}
