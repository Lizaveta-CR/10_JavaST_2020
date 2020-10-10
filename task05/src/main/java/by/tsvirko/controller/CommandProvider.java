package main.java.by.tsvirko.controller;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.controller.command.CommandName;
import main.java.by.tsvirko.controller.command.impl.Task1;
import main.java.by.tsvirko.controller.command.impl.Task2;
import main.java.by.tsvirko.controller.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.TASK1, new Task1());
        repository.put(CommandName.TASK2, new Task2());
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
