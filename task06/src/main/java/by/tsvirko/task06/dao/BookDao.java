package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Book;

import java.io.IOException;

public interface BookDao {
    void create(Book book) throws DaoStorageException;

    void delete(Book book) throws DaoStorageException;

    Book read(Book book) throws DaoStorageException;
}
