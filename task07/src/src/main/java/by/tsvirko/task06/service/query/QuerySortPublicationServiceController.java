package by.tsvirko.task06.service.query;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.repositoryFactory.RepositoryFactory;
import by.tsvirko.task06.service.WritingService;
import by.tsvirko.task06.service.impl.WritingServiceImpl;
import by.tsvirko.task06.service.query.providers.QuerySortPublicationProvider;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Query sorting controller
 */
public class QuerySortPublicationServiceController {
    private static final Logger logger = LogManager.getLogger(QuerySortPublicationServiceController.class);

    private final QuerySortPublicationProvider provider = new QuerySortPublicationProvider();
    private RepositoryFactory factory = RepositoryFactory.getInstance();

    public String sort(String request) throws IOException {
        String commandName;
        Query query;
        String response = null;

        try {
            commandName = request;
            query = provider.getCommand(commandName);
            PublicationRepository bookRepository = factory.getBookRepository();
            List<Book> books = bookRepository.query(query);
            WritingService writingServicempl = new WritingServiceImpl();
            String resultSortFile = "ResultSort";
            String file = resultSortFile.concat(commandName);
            for (int i = 0; i < books.size(); i++) {
                writingServicempl.writeResult(books.get(i), file);
            }
            response = "Sort has been done";
            logger.info(response);
        } catch (RequestException | FindException e) {
            response = "No such sort";
            logger.debug(response, e.getMessage());
        }
        return response;
    }
}

