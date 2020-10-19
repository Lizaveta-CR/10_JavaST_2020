package by.tsvirko.task06.repository.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.dao.impl.BookDaoImpl;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao = new BookDaoImpl();
//
//    public void initBookDao(Book book) {
//        try {
//            fileBookRepository.write(book);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void addBook(Book book) throws BookStorageElementException {
        //TODO:file
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
    public List<Book> query(Query<Book, BookStorage> bookQuery) throws BookStorageElementException {
        return bookDao.query(bookQuery);
    }
}
