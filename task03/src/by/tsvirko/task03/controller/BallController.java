package by.tsvirko.task03.controller;

import by.tsvirko.task03.view.BallView;

import java.util.InputMismatchException;

public class BallController {
    public static void main(String[] args) {
        try {
            BallView ballView = new BallView();
            ballView.viewBallsFilling();
        } catch (InputMismatchException e) {
            System.err.println("Try again..");
        }
    }
}
