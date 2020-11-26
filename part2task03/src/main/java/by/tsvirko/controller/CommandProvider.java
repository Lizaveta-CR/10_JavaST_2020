package by.tsvirko.controller;

import by.tsvirko.controller.command.Command;
import by.tsvirko.controller.command.CommandName;
import by.tsvirko.controller.command.exception.RequestException;
import by.tsvirko.controller.command.impl.DOMCommand;
import by.tsvirko.controller.command.impl.SAXCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides different commands
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        repository.put(CommandName.DOM, new DOMCommand());
        repository.put(CommandName.SAX, new SAXCommand());
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
