package by.tsvirko.task06.controller;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.controller.command.CommandName;
import by.tsvirko.task06.controller.command.impl.*;
import by.tsvirko.task06.controller.exception.RequestException;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    public CommandProvider() {
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.BOOK_FIELDS, new BookFields());
        repository.put(CommandName.INIT_STORAGE, new InitStorage());
        repository.put(CommandName.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandName.SORT, new SortBooks());
        repository.put(CommandName.FIND, new FindBooks());
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
