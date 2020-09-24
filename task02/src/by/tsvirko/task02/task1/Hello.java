package by.tsvirko.task02.task1;

import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            showHello(name);
        } catch (IllegalArgumentException e) {
            System.err.println("Check your name!");
        }

    }

    private static void showHello(String name) {
        ValidateName validateName = new ValidateName();
        if (validateName.validateUserName(name)) {
            String nameLang = validateName.chooseLanguage(name);
            System.out.println(nameLang + name + "!");
        } else {
            throw new IllegalArgumentException();
        }
    }
}
