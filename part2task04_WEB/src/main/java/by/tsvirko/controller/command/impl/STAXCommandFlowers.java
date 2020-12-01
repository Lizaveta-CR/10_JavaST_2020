package by.tsvirko.controller.command.impl;

import by.tsvirko.controller.command.Command;
import by.tsvirko.entity.flowers.Flower;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.factory.ParserFactory;

import java.util.Set;

public class STAXCommandFlowers implements Command<Flower> {
    @Override
    public Set<Flower> execute(String request) {
        BaseBuilder<Flower> flowerParser = ParserFactory.getInstance().createParser("STAX_FLOWERS");
        flowerParser.build();
        return flowerParser.getItems();
    }
}