package by.tsvirko.controller;

import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.factory.ParserFactory;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        BaseBuilder dom = ParserFactory.getInstance().createFlowerParser("DOM");
        //        ClassLoader classLoader = Runner.class.getClassLoader();
        //        File file = new File(classLoader.getResource("data/flowers.xml").getFile());
        dom.buildFlowers();
        dom.getFlowers().forEach(System.out::println);
    }
}
