package by.tsvirko.task02.task4;

import java.io.Console;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. A password must have at least six characters.\n" +
                "2. A password consists of only letters and digits.\n" +
                "3. A password must contain at least two digits\n");
        String password = scanner.nextLine();
        if (ValidatePassword.isValid(password)) {
            System.out.println(password + " is valid");
        } else {
            System.out.println(password + " is not valid");
        }
    }
}
