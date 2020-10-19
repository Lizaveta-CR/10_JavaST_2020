package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.service.BookFieldsService;
import by.tsvirko.task06.service.factory.ServiceFactory;

import java.util.List;

public class BookFields implements Command {
    //TODO:logger
    @Override
    public String execute(List<String> request) {
        String response = null;
        ServiceFactory factory = ServiceFactory.getInstance();
        BookFieldsService service = factory.getService();
        try {
            StringBuilder bookFields = service.getBookFields();
            response = bookFields.toString();
        } catch (BookStorageElementException e) {
            System.err.println(e.getCause());
        }
        return response;
    }
}
