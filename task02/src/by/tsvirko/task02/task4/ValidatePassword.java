package by.tsvirko.task02.task4;

public class ValidatePassword {
    private static final int MAX_LENGTH = 6;

    public static boolean isValid(String pass) {
        if (pass.length() < MAX_LENGTH) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < pass.length(); i++) {
            char ch = pass.charAt(i);
            if (isNumeric(ch)) {
                numCount++;
            } else if (isLetter(ch)) {
                charCount++;
            } else return false;
        }
        return (charCount >= 2 && numCount >= 2);
    }

    private static boolean isNumeric(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
}
