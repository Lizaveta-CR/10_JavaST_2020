package by.tsvirko.task06.service.query;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.impl.FileBookServicempl;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;
import by.tsvirko.task06.service.query.providers.QueryFindProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Finds special 'find' query by command and using RepositoryFactory writes result to file
 */
public class QueryFindServiceController {
    private static final Logger logger = LogManager.getLogger(QueryFindServiceController.class);

    private RepositoryFactory factory = RepositoryFactory.getInstance();

    public String find(List<String> request) throws IOException {
        String commandName;
        Query query;
        String response = null;

        try {
            commandName = request.get(0);
            QueryFindProvider provider = new QueryFindProvider(request);
            query = provider.getCommand(commandName);
            BookRepository bookRepository = factory.getBookRepository();
            List<Book> books = bookRepository.query(query);
            FileBookService fileBookServicempl = new FileBookServicempl();
            String resultSortFile = "ResultFind";
            String file = resultSortFile.concat(commandName);
            for (int i = 0; i < books.size(); i++) {
                fileBookServicempl.writeResult(books.get(i), file);
            }
            response = "Finding has been done";
            logger.info(response);
        } catch (RequestException | FindException e) {
            response = "No such find method";
            logger.debug(response, e.getMessage());
        }
        return response;
    }
}
