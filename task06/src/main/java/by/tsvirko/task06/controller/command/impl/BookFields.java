package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.BookFieldsService;
import by.tsvirko.task06.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Class to return entity fields
 */
public class BookFields implements Command {
    private static final Logger logger = LogManager.getLogger(BookFields.class);

    @Override
    public String execute(List<String> request) {
        String response = null;
        ServiceFactory factory = ServiceFactory.getInstance();
        BookFieldsService service = factory.getService();
        try {
            StringBuilder bookFields = service.getBookFields();
            response = bookFields.toString();
            logger.info(response);
        } catch (BookStorageElementException e) {
            response = "No book fields";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
