package main.java.by.tsvirko.controller.command.impl;

import main.java.by.tsvirko.controller.command.Command;

import java.util.List;

public class Task2 implements Command {
    @Override
    public String execute(List<String> request) {
        return "Hello from Task2";
    }
}
