package by.tsvirko.task09.service.query;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
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
        Composite response = null;

        try {
            commandName = request;
            query = provider.getCommand(commandName);
            TextStorageRepository repository = RepositoryFactory.getInstance().getTextStorageRepository();
            response = repository.query(query);
            logger.info("Sorting has been done");
        } catch (RequestException e) {
            logger.debug(e.getMessage());
        }
        return response;
    }
}
