package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.query.QuerySortServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Class to sort books
 */
public class SortBooks implements Command {
    private static final Logger logger = LogManager.getLogger(SortBooks.class);

    @Override
    public String execute(List<String> request) {
        String response = null;
        QueryFactory factory = QueryFactory.getFactory();
        QuerySortServiceController serviceController = factory.getQuerySortServiceController();
        try {
            response = serviceController.sort(request.get(0));
            logger.info("Books were sorted");
        } catch (IOException e) {
            response = "Error with storage";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
