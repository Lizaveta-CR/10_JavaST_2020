package by.tsvirko.task02.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateName {
    private static final String RUSSIAN_HELLO = "Здравствуйте, ";
    private static final String ENGLISH_HELLO = "Hello, ";

    public boolean validateUserName(String name) {
        return !containsSpecialChars(name) && !containsDigits(name);
    }

    public boolean containsSpecialChars(String name) {
        Pattern pattern = Pattern.compile("[^\\p{L}\\d\\s_]");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public boolean containsDigits(String name) {
        return !name.matches("\\D*");
    }

    public boolean containsRussianSymbols(String name) {
        //TODO:rus+eng
        return !name.matches("^\\w+$");
    }

    public String chooseLanguage(String name) {
        return containsRussianSymbols(name) ? RUSSIAN_HELLO : ENGLISH_HELLO;
    }
}
