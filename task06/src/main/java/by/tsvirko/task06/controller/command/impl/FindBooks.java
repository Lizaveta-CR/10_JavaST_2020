package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.service.query.QueryFindServiceController;
import by.tsvirko.task06.service.query.query_factory.QueryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class FindBooks implements Command {
    private static final Logger logger = LogManager.getLogger(FindBooks.class);

    @Override
    public String execute(List<String> request) {
        String response = null;
        QueryFactory factory = QueryFactory.getFactory();
        QueryFindServiceController queryFindServiceController = factory.getQueryFindServiceController();
        try {
            response = queryFindServiceController.find(request);
            logger.info("Books were found");
        } catch (IOException e) {
            response = "No such books";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
