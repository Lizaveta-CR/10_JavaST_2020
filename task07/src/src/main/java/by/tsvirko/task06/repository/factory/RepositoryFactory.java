package by.tsvirko.task06.repository.factory;

import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.impl.BookRepositoryImpl;

public class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();

    private BookRepository bookRepository = new BookRepositoryImpl();

    public static RepositoryFactory getInstance() {
        return instance;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }
}
