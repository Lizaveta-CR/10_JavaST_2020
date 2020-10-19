package by.tsvirko.repository;


import by.tsvirko.dao.exception.BookStorageElementException;
import by.tsvirko.entity.Book;
import by.tsvirko.entity.BookStorage;
import by.tsvirko.repository.query.Query;

import java.util.List;

public interface BookRepository {
    void addBook(Book book) throws BookStorageElementException;

    void removeBook(Book book) throws BookStorageElementException;

    List<Book> query(Query<Book, BookStorage> bookQuery) throws BookStorageElementException;
}
