package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class to initialize storage
 */
public class InitStorage implements Command {
    private static final Logger logger = LogManager.getLogger(InitStorage.class);

    @Override
    public String execute(List<String> request) {
        ServiceFactory instance = ServiceFactory.getInstance();
        String response = null;
        try {
            instance.getBookService().initBookStorageRandom();
            response = "Info has been written";
            logger.debug(response);
        } catch (ServiceInitException e) {
            response = "Error with storage initialization";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
