package by.tsvirko.task06.service.query;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.repositoryFactory.RepositoryFactory;
import by.tsvirko.task06.service.WritingService;
import by.tsvirko.task06.service.impl.WritingServiceImpl;
import by.tsvirko.task06.service.query.providers.QueryFindPublicationProvider;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Query finding controller
 */
public class QueryFindPublicationServiceController {
    private static final Logger logger = LogManager.getLogger(QueryFindPublicationServiceController.class);

    private RepositoryFactory factory = RepositoryFactory.getInstance();

    public List<Publication> find(List<String> request) throws IOException {
        String commandName;
        Query query;
        String response = null;
        List<Publication> books = null;
        try {
            commandName = request.get(0);
            QueryFindPublicationProvider provider = new QueryFindPublicationProvider(request);
            query = provider.getCommand(commandName);
            PublicationRepository bookRepository = factory.getBookRepository();
            books = bookRepository.query(query);
            WritingService writingServicempl = new WritingServiceImpl();
            String resultSortFile = "ResultFindPublication";
            String file = resultSortFile.concat(commandName);
            for (int i = 0; i < books.size(); i++) {
                writingServicempl.writeResult(books.get(i), file);
            }
            request.remove(0);
            response = "Finding has been done";
            logger.info(response);
        } catch (RequestException | FindException e) {
            response = "No such find method";
            logger.debug(response, e.getMessage());
        }
        return books;
    }
}
