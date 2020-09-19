package by.tsvirko.task01.controller;

//TODO: classname convention

import by.tsvirko.task01.service.PerfectNumber;
import by.tsvirko.task01.service.readingInformation.ConsoleReader;
import by.tsvirko.task01.service.readingInformation.Reader;

import java.util.Scanner;

public class CheckPerfectNumber {
    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        int i = reader.readInt();
        System.out.println(PerfectNumber.isPerfectNumber(i));
    }
}
