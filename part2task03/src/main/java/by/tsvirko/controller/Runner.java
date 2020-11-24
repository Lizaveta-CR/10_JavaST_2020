package by.tsvirko.controller;

import by.tsvirko.service.FlowersDOMBuilder;

public class Runner {
    public static void main(String[] args) {
        FlowersDOMBuilder domBuilder = new FlowersDOMBuilder();
        domBuilder.buildSetStudents("/Users/elizaveta/Downloads/10_JavaST_2020/part2task03/src/main/resources/data/flowers.xml");
        System.out.println(domBuilder.getFlowers());
    }
}
