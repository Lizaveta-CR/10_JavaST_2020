package by.tsvirko.task06.repository.impl;

import by.tsvirko.task06.dao.BookDao;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.dao.impl.BookDaoImpl;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.repository.BookRepository;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookRepositoryImpl implements BookRepository {
    private BookDao bookDao = new BookDaoImpl();
    private BookStorage bookStorage = BookStorage.getInstance();

    @Override
    public void addBook(Book book) throws BookStorageElementException {
        bookStorage.setStorageElement(book);
        try {
            bookDao.create(book);
        } catch (IOException e) {
            throw new BookStorageElementException("Element can't be saved");
        }
    }

    @Override
    public void removeBook(Book book) throws BookStorageElementException {
        bookStorage.removeStorageElement(book);
        try {
            bookDao.delete(book);
        } catch (IOException e) {
            throw new BookStorageElementException("Element can't be saved");
        }
    }

    @Override
    public Book getBook(Book book) throws BookStorageElementException {
        return bookStorage.getStorageElement(book);
    }

    @Override
    public Book getBook(int i) throws BookStorageElementException {
        return bookStorage.getStorageElement(i);
    }

    @Override
    public List<Book> query(Query<Book, BookStorage> bookQuery) throws FindException {
        List<Book> books = new ArrayList<>();
        List<Book> query = null;
        try {
            for (int i = 0; i < bookStorage.getSize(); i++) {
                books.add(bookStorage.getStorageElement(i));
            }
            query = bookQuery.query(bookStorage);
        } catch (BookStorageElementException | FindException | NoAuthorsException e) {
            throw new FindException(e.getCause());
        }
        return query;
    }

    @Override
    public void addRandomBook() throws IOException, BookStorageElementException {
        Set<String> harry = new HashSet<>();
        harry.add("J.K.Rowling");
        Book book = new Book("Harry Potter", harry, 10000, "USA House", 2000);
        Set<String> warAndPiece = new HashSet<>();
        warAndPiece.add("Tolstoy");
        Book book1 = new Book("War and piece", warAndPiece, 1225, "unknown", 1865);
        //TODO: add logSet<String> warAndPiece = new HashSet<>();
        Set<String> q = new HashSet<>();
        q.add("q");
        Book book2 = new Book("q", q, 1, "q", 1);
        bookStorage.setStorageElement(book);
        bookStorage.setStorageElement(book1);
        bookStorage.setStorageElement(book2);
        bookDao.create(book);
        bookDao.create(book1);
        bookDao.create(book2);
    }
}
