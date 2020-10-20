package by.tsvirko.task06.service;

import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.exception.ServiceInitException;

import java.util.List;

public interface BookService {
    void addBook(List<String> book) throws BookStorageElementException, ServiceInitException;

    void removeBook(List<String> book) throws BookStorageElementException, ServiceInitException;

    void initBookStorageRandom() throws ServiceInitException;
}
