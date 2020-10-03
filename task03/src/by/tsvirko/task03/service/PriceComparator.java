package by.tsvirko.task03.service;

import by.tsvirko.task03.entity.Ball;

import java.util.Comparator;

public class PriceComparator implements Comparator<Ball> {
    @Override
    public int compare(Ball o1, Ball o2) {
        return o1.getPrice().compareTo(o2.getPrice());
    }
}
