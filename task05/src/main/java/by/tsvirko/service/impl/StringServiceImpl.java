package main.java.by.tsvirko.service.impl;

import main.java.by.tsvirko.service.StringService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * Replaces words of given length in the text with given string
     *
     * @param text
     * @param substring
     * @param wordLengthToReplace
     * @return new replaced text
     */
    @Override
    public String replaceWithSubstring(String text, String substring, int wordLengthToReplace) {
        StringBuilder builder = new StringBuilder(text);
        Pattern compile = Pattern.compile("\\b\\w{" + wordLengthToReplace + "}\\b", Pattern.MULTILINE);
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            replaceAll(builder, matcher.group(0), substring);
        }
        return builder.toString();
    }

    /**
     * Since StringBuilder does not have replaceAll() method, this method allows to replace given occurrence
     * in whole text without creating new object
     *
     * @param sb
     * @param find
     * @param replace
     */
    private void replaceAll(StringBuilder sb, String find, String replace) {
        Pattern p = Pattern.compile(find);
        Matcher matcher = p.matcher(sb);

        int startIndex = 0;
        while (matcher.find(startIndex)) {
            sb.replace(matcher.start(), matcher.end(), replace);
            startIndex = matcher.start() + replace.length();
        }
    }
}
