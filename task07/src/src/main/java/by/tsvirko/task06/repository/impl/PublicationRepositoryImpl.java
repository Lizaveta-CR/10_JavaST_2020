package by.tsvirko.task06.repository.impl;

import by.tsvirko.task06.dao.PublicationDao;
import by.tsvirko.task06.dao.exception.DaoStorageException;
import by.tsvirko.task06.dao.impl.PublicationDaoImpl;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.entity.observer.Librarian;
import by.tsvirko.task06.entity.observer.Observer;
import by.tsvirko.task06.repository.PublicationRepository;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.repository.repositoryFactory.RepositoryFactory;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class PublicationRepositoryImpl implements PublicationRepository {
    private static final Logger logger = LogManager.getLogger(PublicationRepositoryImpl.class);

    private PublicationDao publicationDao = new PublicationDaoImpl();
    private PublicationStorage bookStorage = PublicationStorage.getInstance();

    /**
     * Adds book to storage and passes it to BookDao
     *
     * @param publication
     * @throws BookStorageElementException
     */
    @Override
    public void addPublication(Publication publication) throws BookStorageElementException {
        publication.setId(UUID.randomUUID().toString());
        bookStorage.setStorageElement(publication);
        try {
            publicationDao.create(publication);
        } catch (DaoStorageException e) {
            logger.info("Book repository can not save element", e.getMessage());
            throw new BookStorageElementException("Element can't be saved");
        }
    }

    /**
     * Removes book from storage and passes it to BookDao
     *
     * @param publication
     * @throws BookStorageElementException
     */
    @Override
    public void removePublication(Publication publication) throws BookStorageElementException {
        bookStorage.removeStorageElement(publication);
        try {
            publicationDao.delete(publication);
        } catch (DaoStorageException e) {
            logger.info("Book repository can not delete element", e.getMessage());
            throw new BookStorageElementException("Element can't be deleted");
        }
    }

    /**
     * Updates publicationOld with publicationNew in storage and passes it to dao
     * <p>
     *
     * @param publicationOld,publicationNew
     */
    @Override
    public void updatePublication(Publication publicationOld, Publication publicationNew) throws BookStorageElementException {
        try {

            String id = publicationOld.getId();
            bookStorage.removeStorageElement(publicationOld);
            publicationNew.setId(id);
            bookStorage.setStorageElement(publicationNew);
            publicationDao.update(publicationOld, publicationNew);
        } catch (BookStorageElementException | DaoStorageException e) {
            logger.info("Book repository can not update publication", e.getMessage());
            throw new BookStorageElementException("Element can't be updated");
        }

    }

    /**
     * Gets book from storage
     *
     * @param publication
     * @return
     * @throws BookStorageElementException
     */
    @Override
    public Publication getPublication(Publication publication) throws BookStorageElementException {
        return bookStorage.getStorageElement(publication);
    }

    /**
     * Makes user's operations with storage
     *
     * @param bookQuery
     * @return
     * @throws FindException
     */
    @Override
    public List<Publication> query(Query<Publication, PublicationStorage> bookQuery) throws FindException {
        List<Publication> publications = new ArrayList<>();
        List<Publication> query = null;
        try {
            for (int i = 0; i < bookStorage.getSize(); i++) {
                publications.add(bookStorage.getStorageElement(i));
            }
            query = bookQuery.query(bookStorage);
        } catch (FindException | NoAuthorsException | BookStorageElementException e) {
            logger.info(e.getMessage());
            throw new FindException(e.getCause());
        }
        return query;
    }

    @Override
    public void setObserver(Observer observer) {
        bookStorage.register(observer);
    }

    /**
     * Adds random books to storage and passes it to BookDAO
     *
     * @throws BookStorageElementException
     */
    @Override
    public void addRandomPublication() throws BookStorageElementException {
        Set<String> harry = new HashSet<>();
        harry.add("J.K.Rowling");
        //TODO:fabric
        Publication book = new Book("Harry Potter", harry, 10000, "USA House", 2000);
        Set<String> warAndPiece = new HashSet<>();
        warAndPiece.add("Tolstoy");
        Publication book1 = new Book("War and piece", warAndPiece, 1225, "unknown", 1865);
        Set<String> q = new HashSet<>();
        q.add("q");
        Publication book2 = new Book("q", q, 1, "q", 1);
        Publication magazine1 = new Magazine("Vogue", 123, "gloss", "q");
//        Publication magazine2 = new Magazine("Bazar", 123, "gloss", "w");
        book.setId("li");
        book1.setId(UUID.randomUUID().toString());
        book2.setId(UUID.randomUUID().toString());
        magazine1.setId("il");
//        magazine2.setId(UUID.randomUUID().toString());
        bookStorage.setStorageElement(book);
        bookStorage.setStorageElement(book1);
        bookStorage.setStorageElement(book2);
        bookStorage.setStorageElement(magazine1);
//        bookStorage.setStorageElement(magazine2);
        try {
            publicationDao.create(book);
            publicationDao.create(book1);
            publicationDao.create(book2);
//            publicationDao.create(magazine1);
//            publicationDao.create(magazine2);
        } catch (DaoStorageException e) {
            throw new BookStorageElementException("Can not save publications to storage");
        }

    }
}
