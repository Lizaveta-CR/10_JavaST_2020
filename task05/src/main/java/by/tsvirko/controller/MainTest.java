package main.java.by.tsvirko.controller;


public class MainTest {
    public static void main(String[] args) {
        String string = "after a letter, for example, P, if it is not the last in the word, a letter is mistakenly typed," +
                " for example, A, instead of, for example, O.";
        String ss = replace(string, 'e', 't', 'Ы');
        System.out.println(ss);
    }

    public static String replace(String text, char predLetter, char mistakeLetter, char correctLetter) {
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
