package by.tsvirko.exampleInt.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        System.out.println("1 — английский /n 2 — белорусский \n 3 — русский ");

        char i = 0;
        try {
            i = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String country = "US";
        String language = "en";
        switch (i) {
            case '2':
                country = "BY";
                language = "by";
                break;
            case '3':
                country = "RU";
                language = "ru";
                break;
            case '1':
                country = "US";
                language = "en";
                break;
            default:

        }

        Locale current = new Locale(language, country);


        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        String s1 = rb.getString("message.str1");
        System.out.println("s1 = " + s1);
        String s2 = rb.getString("message.str2");
        System.out.println(s2);
    }
}
