package by.tsvirko.task06.service.impl;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.repository.repositoryFactory.RepositoryFactory;
import by.tsvirko.task06.service.PublicationService;
import by.tsvirko.task06.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PublicationServiceImpl implements PublicationService {
    private static final Logger logger = LogManager.getLogger(PublicationServiceImpl.class);

    private RepositoryFactory factory = RepositoryFactory.getInstance();

    /**
     * Calls BookRepository to add publication to storage.
     *
     * @param publication
     * @throws ServiceInitException
     */
    @Override
    public void addPublication(Publication publication) throws ServiceInitException {
        try {
            PublicationRepository bookRepository = factory.getBookRepository();
            bookRepository.addPublication(publication);
        } catch (BookStorageElementException e) {
            logger.debug(e.getMessage());
            throw new ServiceInitException(e.getMessage());
        }
    }

    /**
     * Calls BookRepository to remove publication from storage.
     *
     * @param publication
     * @throws ServiceInitException
     */
    @Override
    public void removePublication(Publication publication) throws ServiceInitException {
        try {
            PublicationRepository bookRepository = factory.getBookRepository();
            bookRepository.removePublication(publication);
        } catch (BookStorageElementException e) {
            logger.debug(e.getMessage());
            throw new ServiceInitException(e.getMessage());
        }
    }

    /**
     * Updates publicationOld with publicationNew in storage and passes it to publication repository
     * <p>
     *
     * @param publication,publicationNew
     */
    @Override
    public void updatePublication(Publication publication, Publication publicationNew) throws ServiceInitException {
        PublicationRepository bookRepository = factory.getBookRepository();
        try {
            bookRepository.updatePublication(publication, publicationNew);
        } catch (BookStorageElementException e) {
            logger.debug(e.getMessage());
            throw new ServiceInitException(e.getMessage());
        }
    }

    /**
     * Calls BookRepository to add random publications to storage.
     *
     * @throws ServiceInitException
     */
    @Override
    public void initStorageRandom() throws ServiceInitException {
        PublicationRepository bookRepository = factory.getBookRepository();
        try {
            bookRepository.addRandomPublication();
        } catch (BookStorageElementException e) {
            logger.debug("initBookStorageRandom in book service error", e.getMessage());
            throw new ServiceInitException("Can't initialize books");
        }
    }
}


