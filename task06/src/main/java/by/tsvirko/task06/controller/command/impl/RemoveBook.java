package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class to remove book from storage
 */
public class RemoveBook implements Command {
    private static final Logger logger = LogManager.getLogger(RemoveBook.class);

    @Override
    public String execute(List<String> request) {
        ServiceFactory instance = ServiceFactory.getInstance();
        BookService bookService = instance.getBookService();
        String response = null;
        try {
            bookService.removeBook(request);
            response = "Book was removed";
            logger.info(response);
        } catch (BookStorageElementException | ServiceInitException e) {
            response = "Book can't be removed";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
