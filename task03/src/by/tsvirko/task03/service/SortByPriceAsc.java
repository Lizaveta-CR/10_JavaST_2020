package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;

import java.util.Comparator;

public class SortByPriceAsc implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
