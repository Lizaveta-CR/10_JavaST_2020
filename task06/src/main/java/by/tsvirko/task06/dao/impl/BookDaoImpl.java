package by.tsvirko.task06.dao.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.query.Query;

import java.util.List;


public class BookDaoImpl implements BookDao {
    private BookStorage bookStorage = BookStorage.getInstance();

    @Override
    public void addBook(Book book) throws BookStorageElementException {
        bookStorage.setStorageElement(book);
    }

    @Override
    public void removeBook(Book book) throws BookStorageElementException {
        bookStorage.removeStorageElement(book);
    }

    @Override
    public List<Book> query(Query<Book, BookStorage> bookQuery) throws BookStorageElementException {
        return bookQuery.query(bookStorage);
    }
}
