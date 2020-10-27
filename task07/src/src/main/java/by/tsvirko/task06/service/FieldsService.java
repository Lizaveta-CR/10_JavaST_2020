package by.tsvirko.task06.service;

import by.tsvirko.task06.repository.exception.BookStorageElementException;

public interface FieldsService {
    StringBuilder getPublicationFields() throws BookStorageElementException;
}
