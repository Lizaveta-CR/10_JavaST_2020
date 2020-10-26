package by.tsvirko.task06.service;


import by.tsvirko.task06.entity.Book;

import java.io.IOException;

public interface FileBookService {
    void writeResult(Book book, String fileName) throws IOException;
}
