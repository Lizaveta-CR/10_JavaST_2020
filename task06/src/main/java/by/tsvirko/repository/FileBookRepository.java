package by.tsvirko.repository;


import by.tsvirko.entity.Book;

import java.io.IOException;
import java.util.List;

public interface FileBookRepository {
    List<Book> read() throws IOException, ClassNotFoundException;

    void write(Book book) throws IOException;
}
