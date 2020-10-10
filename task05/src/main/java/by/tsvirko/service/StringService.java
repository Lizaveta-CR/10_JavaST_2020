package main.java.by.tsvirko.service;

public interface StringService {
    String changeEachSpecificLetterWithSymbol(String text, String indexToRepl, String symbol) throws IllegalArgumentException;
}
