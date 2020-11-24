package by.tsvirko.controller;

import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.factory.ParserFactory;

public class Runner {
    public static void main(String[] args) {
        BaseBuilder dom = ParserFactory.getInstance().createFlowerParser("DOM");
        //TODO: ClassLoader
        dom.buildFlowers("/Users/elizaveta/Downloads/10_JavaST_2020/part2task03/src/main/resources/data/flowers.xml");
        dom.getFlowers().forEach(System.out::println);
    }
}
