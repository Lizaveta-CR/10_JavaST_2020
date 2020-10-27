package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.StorageObserverCreator;
import by.tsvirko.task06.service.factory.ObserverType;
import by.tsvirko.task06.service.factory.StorageObserverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddObserver implements Command {
    private static final Logger logger = LogManager.getLogger(AddObserver.class);

    @Override
    public String execute(List<String> request) {
        StorageObserverCreator factory = StorageObserverFactory.getObserver(ObserverType.valueOf(request.get(0)));
        String response = null;
        factory.addObserver(request.get(1));
        response = "Librarian was added";
        logger.info(response);
        return response;
    }
}
