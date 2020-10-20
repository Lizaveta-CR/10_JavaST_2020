package by.tsvirko.task06.repository;


import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.io.IOException;
import java.util.List;

public interface BookRepository {
    void addBook(Book book) throws BookStorageElementException;

    void addRandomBook() throws BookStorageElementException;

    void removeBook(Book book) throws BookStorageElementException;

    Book getBook(Book book) throws BookStorageElementException;

    Book getBook(int i) throws BookStorageElementException;

    List<Book> query(Query<Book, BookStorage> bookQuery) throws FindException;
}
