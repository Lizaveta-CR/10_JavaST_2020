package by.tsvirko.controller;

import by.tsvirko.controller.command.Command;
import by.tsvirko.controller.command.exception.RequestException;
import by.tsvirko.entity.flowers.Flower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Controller<T> {
    private final CommandProvider provider = new CommandProvider();
    private static final Logger logger = LogManager.getLogger(Controller.class);


    public Set<T> executeTask(String request) {
        Command executionCommand;
        Set<T> response = null;

        try {
            executionCommand = provider.getCommand(request);
            response = executionCommand.execute(request);
        } catch (RequestException e) {
            logger.error(e.getMessage());
        }
        return response;
    }
}
