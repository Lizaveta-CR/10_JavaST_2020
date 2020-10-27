package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.PublicationService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.PublicationFactory;
import by.tsvirko.task06.service.factory.PublicationType;
import by.tsvirko.task06.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class to remove publication from storage
 */
public class RemoveBook implements Command {
    private static final Logger logger = LogManager.getLogger(RemoveBook.class);

    @Override
    public String execute(List<String> request) {
        ServiceFactory instance = ServiceFactory.getInstance();
        String response = null;
        try {
            PublicationCreator publication = PublicationFactory.getPublication(PublicationType.valueOf(request.get(0)));
            request.remove(0);
            instance.getPublicationService().removePublication(publication.create(request));
            response = "publication was removed";
            logger.info(response);
        } catch (BookStorageElementException | ServiceInitException e) {
            response = "publication can't be removed";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
