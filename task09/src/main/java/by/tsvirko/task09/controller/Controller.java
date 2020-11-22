package by.tsvirko.task09.controller;

import by.tsvirko.task09.controller.command.Command;
import by.tsvirko.task09.service.query.exception.RequestExceptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class Controller {
    private final CommandProvider provider = new CommandProvider();
    private static final Logger logger = LogManager.getLogger(Controller.class);


    public Optional<String> executeTask(List<String> request) {
        String commandName;
        Command executionCommand;
        Optional<String> response = null;

        try {
            commandName = request.get(0);
            executionCommand = provider.getCommand(commandName);
            request.remove(0);
            response = executionCommand.execute(request);
        } catch (RequestExceptionService e) {
            logger.error(e.getMessage());
        }
        return response;
    }
}
