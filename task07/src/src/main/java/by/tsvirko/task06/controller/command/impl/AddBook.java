package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.PublicationFactory;
import by.tsvirko.task06.service.factory.PublicationType;
import by.tsvirko.task06.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Adds book to storage
 */
public class AddBook implements Command {
    private static final Logger logger = LogManager.getLogger(AddBook.class);

    @Override
    public String execute(List<String> request) {
        ServiceFactory instance = ServiceFactory.getInstance();
        PublicationCreator publication = PublicationFactory.getPublication(PublicationType.valueOf(request.get(0)));
        String response = null;
        try {
            request.remove(0);
            instance.getPublicationService().addPublication(publication.create(request));
            response = "Publication was added";
            logger.info(response);
        } catch (BookStorageElementException | ServiceInitException e) {
            response = "Publication can't be added";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
