package by.tsvirko.task06.service;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.exception.ServiceInitException;

import java.util.List;

public interface PublicationService {
    void addPublication(Publication publication) throws BookStorageElementException, ServiceInitException;

    void removePublication(Publication publication) throws BookStorageElementException, ServiceInitException;

    void updatePublication(Publication publicationOld, Publication publicationNew) throws ServiceInitException;

    void initStorageRandom() throws ServiceInitException;
}
