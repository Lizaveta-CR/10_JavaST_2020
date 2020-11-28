package by.tsvirko.controller.command.impl;

import by.tsvirko.controller.command.Command;
import by.tsvirko.entity.orders.Order;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.factory.ParserFactory;

import java.util.Set;

public class DOMCommandOrders implements Command<Order> {
    @Override
    public Set<Order> execute(String request) {
        BaseBuilder<Order> orderParser = ParserFactory.getInstance().createParser("DOM_ORDERS");
        orderParser.build();
        return orderParser.getItems();
    }
}
