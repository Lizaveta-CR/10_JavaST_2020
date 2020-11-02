package by.tsvirko;

public class StoreNew extends Thread {
    private int product = 0;

    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void get() {
        //Когда в методе put() добавляется товар и вызывается notify(), то метод get() получает монитор и выходит из конструкции while (product<1), так как товар добавлен.
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();//дает сигнал методу put() продолжить работу.
    }

}
