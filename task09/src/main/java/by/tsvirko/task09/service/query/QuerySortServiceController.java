package by.tsvirko.task09.service.query;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.query.exception.RequestException;
import by.tsvirko.task09.service.query.providers.QuerySortProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuerySortServiceController {
    private static final Logger logger = LogManager.getLogger(QuerySortServiceController.class);

    private final QuerySortProvider provider = new QuerySortProvider();

    public Composite sort(String request) {
        String commandName;
        Query query;
        String response = null;

        try {
            commandName = request;
            query = provider.getCommand(commandName);
            response = "Sort has been done";
            logger.info(response);
        } catch (RequestException e) {
            response = "No such sort";
            logger.debug(response, e.getMessage());
        }
        return null;
    }
}
