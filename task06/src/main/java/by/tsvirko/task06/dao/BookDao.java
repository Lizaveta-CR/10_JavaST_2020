package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.service.query.Query;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookDao {
    void create(Book book) throws BookStorageElementException, IOException;

    void delete(Book book) throws BookStorageElementException, IOException;

    Book read(Book book) throws BookStorageElementException, IOException;

    List<Book> readAll() throws BookStorageElementException, IOException;
}
