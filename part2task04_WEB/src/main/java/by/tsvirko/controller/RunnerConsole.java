package by.tsvirko.controller;

import by.tsvirko.view.ViewConsole;


public class RunnerConsole {
    public static void main(String[] args) {
        ViewConsole viewConsole = new ViewConsole();
        viewConsole.viewFlowers();
        viewConsole.viewOrders();
    }
}
