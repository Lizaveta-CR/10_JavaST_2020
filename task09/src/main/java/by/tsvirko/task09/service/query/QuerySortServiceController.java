package by.tsvirko.task09.service.query;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.exception.ServiceException;
import by.tsvirko.task09.service.query.exception.RequestExceptionService;
import by.tsvirko.task09.service.query.providers.QuerySortProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

/**
 * Query sort controller
 */
public class QuerySortServiceController {
    private static final Logger logger = LogManager.getLogger(QuerySortServiceController.class);

    public Optional<Composite> sort(List<String> request) throws ServiceException {
        String commandName;
        Query query;
        Optional<Composite> response = null;

        try {
            commandName = request.get(0);
            request.remove(0);
            QuerySortProvider provider = new QuerySortProvider(request);
            query = provider.getCommand(commandName);
            TextStorageRepository repository = RepositoryFactory.getInstance().getTextStorageRepository();
            response = Optional.ofNullable(repository.query(query));
            logger.info("Sorting has been done");
        } catch (RequestExceptionService e) {
            logger.debug(e.getMessage());
            throw new ServiceException("Error params in sorting " + e.getMessage());
        }
        return response;
    }
}
