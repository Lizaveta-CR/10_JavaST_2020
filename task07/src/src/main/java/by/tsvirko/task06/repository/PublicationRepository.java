package by.tsvirko.task06.repository;


import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.entity.observer.Observer;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;

import java.util.List;

public interface PublicationRepository {
    void addPublication(Publication publication) throws BookStorageElementException;

    void addRandomPublication() throws BookStorageElementException;

    void removePublication(Publication publication) throws BookStorageElementException;

    void updatePublication(Publication publicationOld, Publication publicationNew) throws BookStorageElementException;

    Publication getPublication(Publication publication) throws BookStorageElementException;

    List<Publication> query(Query<Publication, PublicationStorage> bookQuery) throws FindException;

    void setObserver(Observer observer);
}
