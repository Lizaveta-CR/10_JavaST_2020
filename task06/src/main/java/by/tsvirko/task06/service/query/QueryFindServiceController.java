package by.tsvirko.task06.service.query;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.impl.FileBookServicempl;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;
import by.tsvirko.task06.service.query.providers.QueryFindProvider;
import by.tsvirko.task06.service.query.providers.QuerySortProvider;

import java.io.IOException;
import java.util.List;

public class QueryFindServiceController {
    private RepositoryFactory factory = RepositoryFactory.getInstance();

    public String find(List<String> request) throws IOException {
        String commandName;
        Query query;
        String response = null;

        try {
            commandName = request.get(0);
            QueryFindProvider provider = new QueryFindProvider(request.get(1));
            query = provider.getCommand(commandName);
            BookRepository bookRepository = factory.getBookRepository();
            List<Book> books = bookRepository.query(query);
            FileBookService fileBookServicempl = new FileBookServicempl();
            String resultSortFile = "ResultFind";
            String file = resultSortFile.concat(commandName);
            for (int i = 0; i < books.size(); i++) {
                fileBookServicempl.write(books.get(i), file);
            }
            response = "Sort has been done";
        } catch (RequestException | BookStorageElementException | FindException e) {
            response = "No such sort";
            System.err.println(e.getCause());
        }
        return response;
    }
}
