package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.query.Query;

import java.util.List;

public interface BookDao {
    void addBook(Book book) throws BookStorageElementException;

    void removeBook(Book book) throws BookStorageElementException;

    List<Book> query(Query<Book, BookStorage> bookQuery) throws BookStorageElementException;
//    Set<Book> getBooks() throws BookStorageElementException;
}
