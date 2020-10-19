package by.tsvirko.task06.repository.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.dao.impl.BookDaoImpl;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) throws BookStorageElementException {
        bookDao.create(book);
    }

    @Override
    public void removeBook(Book book) throws BookStorageElementException {
        bookDao.delete(book);
    }

    @Override
    public Book getBook(Book book) throws BookStorageElementException {
        return bookDao.read(book);
    }

    @Override
    public Book getBook(int i) throws BookStorageElementException {
        return bookDao.read(i);
    }

    @Override
    public List<Book> query(Query<Book> bookQuery) throws FindException {
        ArrayList<Book> result = new ArrayList<>();
        List<Book> query = null;
        try {
            query = bookQuery.query(bookDao.readAll());
        } catch (BookStorageElementException | FindException e) {
            throw new FindException(e.getCause());
        }
        result.addAll(query);
        return result;
    }
}
