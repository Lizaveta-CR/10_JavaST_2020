package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.query.QuerySortPublicationServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Class to sort books
 */
public class SortPublication implements Command {
    private static final Logger logger = LogManager.getLogger(SortPublication.class);

    @Override
    public String execute(List<String> request) {
        String response = null;
        QueryFactory factory = QueryFactory.getFactory();
        QuerySortPublicationServiceController sortPublicationServiceController = factory.getQuerySortPublicationServiceController();
        try {
            response = sortPublicationServiceController.sort(request.get(0));
            logger.info("Books were sorted");
        } catch (IOException e) {
            response = "Error with storage";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
