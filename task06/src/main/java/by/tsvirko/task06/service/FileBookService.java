package by.tsvirko.task06.service;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;

import java.io.IOException;
import java.util.List;

public interface FileBookService {
    List<Book> read() throws IOException, ClassNotFoundException;

    void write(Book book, String fileName) throws IOException;

    void writeRandom() throws IOException, BookStorageElementException, ClassNotFoundException;
}
