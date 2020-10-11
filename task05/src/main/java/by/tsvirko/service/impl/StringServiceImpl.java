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
            throw e;
        }
        return sb.toString();
    }

    /**
     * Replaces 'predLetter', if it is not the last in the word,  'mistakeLetter' with 'correctLetter'
     *
     * @param text
     * @param predLetter
     * @param mistakeLetter
     * @param correctLetter
     * @return
     */
    @Override
    public String replace(String text, char predLetter, char mistakeLetter, char correctLetter) {
        String[] strings = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (strings[i].charAt(j) == predLetter) {
                    if (strings[i].lastIndexOf(predLetter) == strings[i].length() - 1) {
                        break;
                    } else {
                        if (strings[i].charAt(j + 1) != ' ' && strings[i].charAt(j + 1) == mistakeLetter) {
                            strings[i] = strings[i].replace(mistakeLetter, correctLetter);
                        }
                    }
                }
            }
            sb.append(strings[i] + " ");
        }
        return sb.toString();
    }
}
