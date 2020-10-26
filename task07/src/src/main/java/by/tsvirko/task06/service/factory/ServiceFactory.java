package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.BookFieldsService;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.impl.BookFieldsServiceImpl;
import by.tsvirko.task06.service.impl.BookServiceImpl;
import by.tsvirko.task06.service.impl.FileBookServicempl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private BookFieldsService service = new BookFieldsServiceImpl();
    private BookService bookService = new BookServiceImpl();
    private FileBookService fileBookService = new FileBookServicempl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public BookFieldsService getService() {
        return service;
    }

    public BookService getBookService() {
        return bookService;
    }

    public FileBookService getFileBookService() {
        return fileBookService;
    }
}
