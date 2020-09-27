package by.tsvirko.task03.controller;

import by.tsvirko.task03.view.MenuView;

import java.util.InputMismatchException;

public class BallController {
    public static void main(String[] args) {
        try {
            MenuView menuView = new MenuView();
            menuView.start();
            menuView.viewTasks();
        } catch (InputMismatchException e) {
            System.err.println("Try again..");
        }
    }
}
