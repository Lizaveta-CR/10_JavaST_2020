package by.tsvirko.task08.controller;

import by.tsvirko.task08.controller.command.Command;
import by.tsvirko.task08.controller.command.CommandName;
import by.tsvirko.task08.controller.command.exception.RequestException;
import by.tsvirko.task08.controller.command.impl.FirstSolution;
import by.tsvirko.task08.controller.command.impl.FourthSolution;
import by.tsvirko.task08.controller.command.impl.ThirdSolution;
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
        repository.put(CommandName.FIRST, new FirstSolution());
        repository.put(CommandName.THIRD, new ThirdSolution());
        repository.put(CommandName.FOURTH, new FourthSolution());
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
