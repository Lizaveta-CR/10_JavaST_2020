package by.tsvirko.task06.controller;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.controller.command.CommandName;
import by.tsvirko.task06.controller.command.impl.*;
import by.tsvirko.task06.controller.exception.RequestException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides different commands to user
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        repository.put(CommandName.ADD_BOOK, new AddBook());
        repository.put(CommandName.BOOK_FIELDS, new BookFields());
        repository.put(CommandName.INIT_STORAGE, new InitStorage());
        repository.put(CommandName.REMOVE_BOOK, new RemoveBook());
        repository.put(CommandName.SORT, new SortPublication());
        repository.put(CommandName.FIND, new FindPublication());
        repository.put(CommandName.OBSERVER, new AddObserver());
        repository.put(CommandName.UPDATE, new UpdatePublication());
    }

    public Command getCommand(String name) throws RequestException {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug("Illegal command name occurred", e);
            throw new RequestException("Illegal command name", e);
        }
        return command;
    }
}
