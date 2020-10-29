package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.PublicationService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.PublicationFactory;
import by.tsvirko.task06.service.factory.PublicationType;
import by.tsvirko.task06.service.factory.ServiceFactory;
import by.tsvirko.task06.service.query.QueryFindPublicationServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class UpdatePublication implements Command {
    private static final Logger logger = LogManager.getLogger(UpdatePublication.class);

    @Override
    public String execute(List<String> request) throws BookStorageElementException {
        ServiceFactory instance = ServiceFactory.getInstance();
        PublicationService publicationService = instance.getPublicationService();
        String response = null;
        try {
            QueryFactory factory = QueryFactory.getFactory();
            QueryFindPublicationServiceController serviceController = factory.getQueryFindPublicationServiceController();
            Publication publ = serviceController.find(request).get(0);
            request.remove(0);
            PublicationCreator publication = PublicationFactory.getPublication(PublicationType.valueOf(request.get(0)));
            request.remove(0);
            publicationService.updatePublication(publ, publication.create(request));
            response = "Publication was added";
            logger.info(response);
        } catch (NullPointerException | ServiceInitException | IOException e) {
            response = "Publication can't be added";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
