package by.tsvirko.task06.repository.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.dao.impl.BookDaoImpl;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.repository.FileBookRepository;
import by.tsvirko.task06.repository.query.Query;

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
