package by.tsvirko;

public class ProducerConsumerAppReentrant {
    public static void main(String[] args) {
        StoreReentrant storeReentrant = new StoreReentrant();
        ProducerReentrant producerReentrant = new ProducerReentrant(storeReentrant);
        ConsumerReentrant consumerReentrant = new ConsumerReentrant(storeReentrant);
        new Thread(producerReentrant).start();
        new Thread(consumerReentrant).start();
    }
}
