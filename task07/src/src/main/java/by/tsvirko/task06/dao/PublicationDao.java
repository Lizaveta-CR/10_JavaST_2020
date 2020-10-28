package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;

import java.io.IOException;

public interface PublicationDao {
    void create(Publication publication) throws DaoStorageException;

    void delete(Publication publication) throws DaoStorageException;

    Publication read(Publication publication) throws DaoStorageException;

    void update(Publication publicationOld, Publication publicationNew) throws DaoStorageException;
}
