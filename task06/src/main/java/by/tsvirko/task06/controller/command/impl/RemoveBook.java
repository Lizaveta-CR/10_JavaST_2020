package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.factory.ServiceFactory;

import java.util.List;

public class RemoveBook implements Command {
    @Override
    public String execute(List<String> request) throws BookStorageElementException {
        ServiceFactory instance = ServiceFactory.getInstance();
        BookService bookService = instance.getBookService();
        String response = null;
        try {
            bookService.removeBook(request);
            response = "Book was removed";
        } catch (BookStorageElementException e) {
            response = "Book can't be removed";
            System.err.println(e.getCause());
        }
        return response;
    }
}
