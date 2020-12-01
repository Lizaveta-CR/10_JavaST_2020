package by.tsvirko.controller.command.impl;

import by.tsvirko.controller.command.Command;
import by.tsvirko.entity.flowers.Flower;
import by.tsvirko.entity.orders.Order;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.factory.ParserFactory;

import java.util.Set;

public class STAXCommandOrders implements Command<Order> {
    @Override
    public Set<Order> execute(String request) {
        BaseBuilder<Order> orders = ParserFactory.getInstance().createParser("STAX_ORDERS");
        orders.build();
        return orders.getItems();
    }
}