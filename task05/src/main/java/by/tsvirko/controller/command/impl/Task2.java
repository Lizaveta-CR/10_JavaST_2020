package main.java.by.tsvirko.controller.command.impl;

import main.java.by.tsvirko.controller.command.Command;

public class Task2 implements Command {
    @Override
    public String execute(String request) {
        return "Hello from Task2";
    }
}
