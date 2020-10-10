package main.java.by.tsvirko.service.impl;

import main.java.by.tsvirko.service.StringService;

public class StringServiceImpl implements StringService {
    /**
     * Method in each word replaces the k-th letter with the given symbol
     *
     * @param text
     * @param indexToRepl
     * @param symbol
     * @return new String with replaced letters
     * @throws IllegalArgumentException
     */
    @Override
    public String changeEachSpecificLetterWithSymbol(String text, String indexToRepl, String symbol) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        try {
            int index = Integer.parseInt(indexToRepl);
            if (!text.isEmpty() && index > 0) {
                for (String word : text.split(" ")) {
                    if (word.length() >= index) {
                        sb.append(word, 0, index - 1).append(symbol).append(word.substring(index));
                    } else {
                        sb.append(word);
                    }
                    sb.append(" ");
                }
            } else {
                throw new IllegalArgumentException("Index can't be negative or zero!");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input values are invalid!", e);
        }
        return sb.toString();
    }
}
