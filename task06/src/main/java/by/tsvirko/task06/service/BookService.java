package by.tsvirko.task06.service;

import by.tsvirko.task06.dao.exception.BookStorageElementException;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void addBook(List<String> book) throws BookStorageElementException;

    void removeBook(List<String> book) throws BookStorageElementException;

    void initBookStorageFromFile() throws IOException, ClassNotFoundException, BookStorageElementException;
}
