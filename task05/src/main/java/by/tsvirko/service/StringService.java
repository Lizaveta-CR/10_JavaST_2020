package main.java.by.tsvirko.service;

public interface StringService {
    String changeEachSpecificLetterWithSymbol(String text, String indexToRepl, String symbol);

    String replace(String text, char predLetter, char mistakeLetter, char correctLetter);
}
