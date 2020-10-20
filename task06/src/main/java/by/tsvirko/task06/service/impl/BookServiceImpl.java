package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.BookService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class BookServiceImpl implements BookService {
    private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

    private RepositoryFactory factory = RepositoryFactory.getInstance();

    /**
     * Calls BookRepository to add book to storage
     *
     * @param bookFieldsUser
     * @throws ServiceInitException
     */
    @Override
    public void addBook(List<String> bookFieldsUser) throws ServiceInitException {
        Book book = null;
        try {
            book = createBook(bookFieldsUser);
            BookRepository bookRepository = factory.getBookRepository();
            bookRepository.addBook(book);
        } catch (ServiceInitException | BookStorageElementException e) {
            logger.debug(e.getMessage());
            throw new ServiceInitException(e.getMessage());
        }
    }

    /**
     * Calls BookRepository to remove book from storage
     *
     * @param bookFieldsUser
     * @throws ServiceInitException
     */
    @Override
    public void removeBook(List<String> bookFieldsUser) throws ServiceInitException {
        Book book = null;
        try {
            book = createBook(bookFieldsUser);
            BookRepository bookRepository = factory.getBookRepository();
            bookRepository.removeBook(book);
        } catch (BookStorageElementException e) {
            logger.debug(e.getMessage());
            throw new ServiceInitException(e.getMessage());
        }

    }

    /**
     * Calls BookRepository to add random books to storage
     *
     * @throws ServiceInitException
     */
    @Override
    public void initBookStorageRandom() throws ServiceInitException {
        BookRepository bookRepository = factory.getBookRepository();
        try {
            bookRepository.addRandomBook();
        } catch (BookStorageElementException e) {
            logger.debug("initBookStorageRandom in service error", e.getMessage());
            throw new ServiceInitException("Can't initialize books");
        }
    }

    /**
     * Creates new book
     *
     * @param bookFieldsUser
     * @return
     * @throws ServiceInitException
     */
    Book createBook(List<String> bookFieldsUser) throws ServiceInitException {
        Book book = new Book();

        try {
            book.setTitle(bookFieldsUser.get(0));
            book.setAuthor(bookFieldsUser.get(1));
            book.setNumberOfPages(Integer.valueOf(bookFieldsUser.get(2)));
            book.setPublishingHouse(bookFieldsUser.get(3));
            book.setYearOfPublishing(Integer.valueOf(bookFieldsUser.get(4)));
        } catch (NumberFormatException e) {
            logger.debug("Create book error", e.getMessage());
            throw new ServiceInitException("Invalid parametres");
        }
        return book;
    }
}
