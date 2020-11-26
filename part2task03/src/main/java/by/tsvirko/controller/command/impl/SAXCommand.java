package by.tsvirko.controller.command.impl;

import by.tsvirko.controller.command.Command;
import by.tsvirko.entity.flowers.Flower;
import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.factory.ParserFactory;

import java.util.Set;

public class SAXCommand implements Command {
    @Override
    public Set<Flower> execute(String request) {
        BaseBuilder flowerParser = ParserFactory.getInstance().createFlowerParser(request);
        flowerParser.buildFlowers();
        return flowerParser.getFlowers();
    }
}
