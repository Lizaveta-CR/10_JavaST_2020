package by.tsvirko.task06.service;

import by.tsvirko.task06.repository.exception.BookStorageElementException;

public abstract class PublicationFieldsCreator {
    public abstract StringBuilder getPublicationFields() throws BookStorageElementException;

}
