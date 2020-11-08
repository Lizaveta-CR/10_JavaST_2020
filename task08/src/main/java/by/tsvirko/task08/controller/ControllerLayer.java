package by.tsvirko.task08.controller;

import by.tsvirko.task08.controller.command.Command;
import by.tsvirko.task08.controller.command.exception.RequestException;
import by.tsvirko.task08.entity.Array;
import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ControllerLayer {
    private final CommandProvider provider = new CommandProvider();
    private static final Logger logger = LogManager.getLogger(ControllerLayer.class);


    public Array executeTask(List<String> request) {
        String commandName;
        Command executionCommand;
        Array response = null;

        try {
            commandName = request.get(0);
            executionCommand = provider.getCommand(commandName);
            request.remove(0);
            response = executionCommand.execute(request);
        } catch (RequestException | MatrixException | ServiceInitException | ArrayException e) {
            logger.error("No such operation, controller error");
        }
        return response;
    }
}
