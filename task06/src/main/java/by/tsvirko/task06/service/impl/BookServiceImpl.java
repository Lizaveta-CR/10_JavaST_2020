package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.factory.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private RepositoryFactory factory = RepositoryFactory.getInstance();

    @Override
    public void addBook(List<String> bookFieldsUser) throws NumberFormatException, BookStorageElementException {
        Book book = createBook(bookFieldsUser);
        BookRepository bookRepository = factory.getBookRepository();
        bookRepository.addBook(book);
    }

    @Override
    public void removeBook(List<String> bookFieldsUser) throws BookStorageElementException {
        Book book = createBook(bookFieldsUser);

        BookRepository bookRepository = factory.getBookRepository();
        bookRepository.removeBook(book);
    }

    @Override
    public void initBookStorageRandom() throws ServiceInitException {
        BookRepository bookRepository = factory.getBookRepository();
        try {
            bookRepository.addRandomBook();
        } catch (IOException | BookStorageElementException e) {
            throw new ServiceInitException("Can't initialize books");
        }
        //logger
    }

    Book createBook(List<String> bookFieldsUser) {
        Book book = new Book();

        book.setTitle(bookFieldsUser.get(0));
        book.setAuthor(bookFieldsUser.get(1));
        book.setNumberOfPages(Integer.valueOf(bookFieldsUser.get(2)));
        book.setPublishingHouse(bookFieldsUser.get(3));
        book.setYearOfPublishing(Integer.valueOf(bookFieldsUser.get(4)));

        return book;
    }
}
