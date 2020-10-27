package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.PublicationFieldsCreator;
import by.tsvirko.task06.service.factory.PublicationFieldsFactory;
import by.tsvirko.task06.service.factory.PublicationType;
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
        PublicationFieldsCreator creator = PublicationFieldsFactory.getFields(PublicationType.valueOf(request.get(0)));
        try {
            StringBuilder bookFields = creator.getPublicationFields();
            response = bookFields.toString();
            logger.info(response);
        } catch (BookStorageElementException e) {
            response = "No fields";
            logger.error(response, e.getMessage());
        }
        return response;
    }
}
