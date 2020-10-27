package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.entity.observer.Librarian;
import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.repositoryFactory.RepositoryFactory;
import by.tsvirko.task06.service.StorageObserverCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LibrarianService extends StorageObserverCreator {
    private RepositoryFactory factory = RepositoryFactory.getInstance();

    @Override
    public void addObserver(String name) {
        PublicationRepository bookRepository = factory.getBookRepository();
        bookRepository.setObserver(new Librarian(name));
    }
}
