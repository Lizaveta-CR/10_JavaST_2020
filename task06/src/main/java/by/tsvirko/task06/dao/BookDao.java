package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.service.query.Query;

import java.util.List;

public interface BookDao {
    void create(Book book) throws BookStorageElementException;

    void delete(Book book) throws BookStorageElementException;

    Book read(Book book) throws BookStorageElementException;

    Book read(int i) throws BookStorageElementException;

    List<Book> readAll() throws BookStorageElementException;
}
