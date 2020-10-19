package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.factory.RepositoryFactory;
import by.tsvirko.task06.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private RepositoryFactory factory = new RepositoryFactory();

    @Override
    public void addBook(List<String> bookFieldsUser) throws NumberFormatException, BookStorageElementException {
        Book book = new Book();

        book.setTitle(bookFieldsUser.get(0));
        book.setAuthor(bookFieldsUser.get(1));
        book.setNumberOfPages(Integer.valueOf(bookFieldsUser.get(2)));
        book.setPublishingHouse(bookFieldsUser.get(3));
        book.setYearOfPublishing(Integer.valueOf(bookFieldsUser.get(4)));

        BookRepository bookRepository = factory.getBookRepository();
        bookRepository.addBook(book);
    }
}
