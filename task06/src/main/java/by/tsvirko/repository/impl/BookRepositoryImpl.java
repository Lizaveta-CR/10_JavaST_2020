package by.tsvirko.repository.impl;

import by.tsvirko.dao.BookDao;
import by.tsvirko.dao.exception.BookStorageElementException;
import by.tsvirko.dao.impl.BookDaoImpl;
import by.tsvirko.entity.Book;
import by.tsvirko.entity.BookStorage;
import by.tsvirko.repository.BookRepository;
import by.tsvirko.repository.FileBookRepository;
import by.tsvirko.repository.query.Query;

import java.io.IOException;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private FileBookRepository fileBookRepository = new FileBookRepositorympl();
    private BookDao bookDao = new BookDaoImpl();


    public void initBookDao(Book book) {
        try {
            fileBookRepository.write(book);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addBook(Book book) throws BookStorageElementException {
        //TODO:file
        bookDao.addBook(book);
    }

    @Override
    public void removeBook(Book book) throws BookStorageElementException {
        bookDao.removeBook(book);
    }

    @Override
    public List<Book> query(Query<Book, BookStorage> bookQuery) throws BookStorageElementException {
        return bookDao.query(bookQuery);
    }
}
