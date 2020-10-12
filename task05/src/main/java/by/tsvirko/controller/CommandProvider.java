package main.java.by.tsvirko.controller;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.controller.command.CommandName;
import main.java.by.tsvirko.controller.command.impl.*;
import main.java.by.tsvirko.controller.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.TASK1, new Task1());
        repository.put(CommandName.TASK2, new Task2());
        repository.put(CommandName.TASK3, new Task3());
        repository.put(CommandName.TASK4, new Task4());
        repository.put(CommandName.TASK5, new Task5());
    }

    public Command getCommand(String name) throws RequestException {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RequestException("Illegal command name", e);
        }
        return command;
    }
}
