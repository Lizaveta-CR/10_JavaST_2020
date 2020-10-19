package by.tsvirko.task06.service;

import by.tsvirko.task06.dao.exception.BookStorageElementException;

public interface BookFieldsService {
    StringBuilder getBookFields() throws BookStorageElementException;
}
