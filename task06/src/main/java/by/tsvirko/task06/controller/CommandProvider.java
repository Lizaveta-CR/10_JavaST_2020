package by.tsvirko.task06.controller;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.controller.command.CommandName;
import by.tsvirko.task06.controller.command.impl.AddBook;
import by.tsvirko.task06.controller.command.impl.BookFields;
import by.tsvirko.task06.controller.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.BOOK_FIELDS, new BookFields());
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
