package by.tsvirko.task06.service;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;

import java.io.IOException;
import java.util.List;

public interface FileBookService {
    void writeResult(Book book, String fileName) throws IOException;
}
