package by.tsvirko;
//Возьмем стандартную задачу из прошлой темы - "Производитель-Потребитель" ("Producer-Consumer"): пока производитель
// не произвел продукт, потребитель не может его купить. Пусть производитель должен произвести 5 товаров, соответственно потребитель должен их все купить. Но при этом одновременно на складе может находиться не более 3 товаров. Для решения этой задачи задействуем методы wait() и notify():

public class ProduserConsumerApp {

    public static void main(String[] args) {
        StoreNew store = new StoreNew();
        new ProduserNew(store).start();
        new ConsumerNew(store).start();
    }
}
