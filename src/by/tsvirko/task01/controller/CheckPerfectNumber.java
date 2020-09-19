package by.tsvirko.task01.controller;

//TODO: classname convention

import by.tsvirko.task01.service.PerfectNumber;
import by.tsvirko.task01.service.readingInformation.FileIntegerReader;
import by.tsvirko.task01.service.readingInformation.IntegerReader;

public class CheckPerfectNumber {
    public static void main(String[] args) {
//        System.out.println("Write positive number and press <Enter>: ");

        IntegerReader reading = new FileIntegerReader("src/by/tsvirko/task01/beans/Numbers");
        int i = reading.readNumber();
        System.out.println(PerfectNumber.isPerfectNumber(i));
    }
}
