package by.tsvirko.controller;

import by.tsvirko.controller.command.Command;
import by.tsvirko.controller.command.CommandName;
import by.tsvirko.controller.command.exception.RequestException;
import by.tsvirko.controller.command.impl.*;
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
        repository.put(CommandName.DOM_FLOWERS, new DOMCommandFlowers());
        repository.put(CommandName.SAX_FLOWERS, new SAXCommandFlowers());
        repository.put(CommandName.STAX_FLOWERS, new STAXCommandFlowers());
        repository.put(CommandName.DOM_ORDERS, new DOMCommandOrders());
        repository.put(CommandName.SAX_ORDERS, new SAXCommandOrders());
        repository.put(CommandName.STAX_ORDERS, new STAXCommandOrders());
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
