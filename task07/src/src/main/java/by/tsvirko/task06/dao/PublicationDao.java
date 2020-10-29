package by.tsvirko.task06.dao;


import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.exception.BookStorageElementException;

import java.util.List;

public interface PublicationDao {
    void create(Publication publication) throws DaoStorageException;

    void delete(Publication publication) throws DaoStorageException;

    Publication read(Publication publication) throws DaoStorageException;

    List<Publication> readAll() throws DaoStorageException;

    void update(Publication publicationOld, Publication publicationNew) throws DaoStorageException;

    void createRandom() throws BookStorageElementException, DaoStorageException;

}
