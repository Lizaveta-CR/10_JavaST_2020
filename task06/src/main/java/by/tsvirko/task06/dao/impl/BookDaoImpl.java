package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.service.query.Query;

import java.util.ArrayList;
import java.util.List;


public class BookDaoImpl implements BookDao {
    private BookStorage bookStorage = BookStorage.getInstance();

    @Override
    public void create(Book book) throws BookStorageElementException {
        bookStorage.setStorageElement(book);
    }

    @Override
    public void delete(Book book) throws BookStorageElementException {
        bookStorage.removeStorageElement(book);
    }

    @Override
    public Book read(Book book) throws BookStorageElementException {
        return bookStorage.getStorageElement(book);
    }

    @Override
    public Book read(int i) throws BookStorageElementException {
        return bookStorage.getStorageElement(i);
    }

    @Override
    public List<Book> readAll() throws BookStorageElementException {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < bookStorage.getSize(); i++) {
            books.add(bookStorage.getStorageElement(i));
        }
        return books;
    }
}
