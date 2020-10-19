package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.BookFieldsService;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.impl.BookFieldsServiceImpl;
import by.tsvirko.task06.service.impl.BookServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private BookFieldsService service = new BookFieldsServiceImpl();
    private BookService bookService = new BookServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BookFieldsService getService() {
        return service;
    }

    public BookService getBookService() {
        return bookService;
    }
}
