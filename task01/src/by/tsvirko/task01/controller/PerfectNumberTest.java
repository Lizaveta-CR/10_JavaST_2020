package by.tsvirko.task01.controller;

import by.tsvirko.task01.service.PerfectNumber;
import by.tsvirko.task01.view.NumbersOutputView;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The PerfectNumberTest program implements an application that
 * returns 'true' if number is perfect and 'false' is it's not.
 *
 * @author Tsvirko Lizaveta
 * @since 2020-09-19
 */
public class PerfectNumberTest {

    public static void main(String[] args) {
        System.out.println("Press 1 if you want to write number "
                + "in console\n" + "Press 2 if you want to "
                + "read number from file");
        Scanner scanner = new Scanner(System.in);
        NumbersOutputView numbersOutputView = new NumbersOutputView();
        try {
            int userNumber = numbersOutputView.getNumber(scanner);
            System.out.println(PerfectNumber.isPerfectNumber(userNumber));
        } catch (InputMismatchException e) {
            System.err.println("Only 1 or 2!");
        }
    }
}
