package by.tsvirko.task06.repository.repositoryFactory;

import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.impl.PublicationRepositoryImpl;

public class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();

    private PublicationRepository bookRepository = new PublicationRepositoryImpl();

    public static RepositoryFactory getInstance() {
        return instance;
    }

    public PublicationRepository getBookRepository() {
        return bookRepository;
    }
}
