package by.tsvirko.exchanger;

import java.util.concurrent.Exchanger;

//содержит Exchanger и представляет основу для производителя и потребителя
public class Subject {
    protected static Exchanger<Item> exchanger = new Exchanger<Item>();
    private String name;
    protected Item item;

    public Subject(String name, Item item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public Item getItem() {
        return item;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
