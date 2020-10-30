package by.tsvirko.task06.entity;

import by.tsvirko.task06.entity.observer.Observer;
import by.tsvirko.task06.entity.observer.Subject;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Class to store books - Singleton,implements Subject interface
 */
public class PublicationStorage implements Subject {
    private static final Logger logger = LogManager.getLogger(PublicationStorage.class);

    private static PublicationStorage instance;
    private Set<Publication> storage = new LinkedHashSet<>();
    private List<Observer> librarians = new ArrayList<>();

    private PublicationStorage() {
    }

    /**
     * Gets instance of PublicationStorage
     *
     * @return PublicationStorage
     */
    public static PublicationStorage getInstance() {
        return (instance == null) ? instance = new PublicationStorage() : instance;
    }

    /**
     * Gets publication from storage by index
     *
     * @param i
     * @return
     * @throws BookStorageElementException
     */
    public Publication getStorageElement(int i) throws BookStorageElementException {
        try {
            return new ArrayList<>(storage).get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new BookStorageElementException("No such book!");
        }
    }

    /**
     * Gets publication from storage by publication
     *
     * @param publication
     * @return
     * @throws BookStorageElementException
     */
    public Publication getStorageElement(Publication publication) throws BookStorageElementException {
        Iterator<Publication> it = storage.iterator();

        while (it.hasNext()) {
            Publication nextBook = it.next();
            if (nextBook.equals(publication)) {
                return nextBook;
            }
        }
        throw new BookStorageElementException("No such publication!");
    }

    /**
     * Gets publication from storage by publication id
     *
     * @param id
     * @return Publication
     * @throws BookStorageElementException
     */
    public Publication getStorageElement(String id) throws BookStorageElementException {
        Iterator<Publication> it = storage.iterator();

        while (it.hasNext()) {
            Publication nextBook = it.next();
            if (nextBook.getId().equals(id)) {
                return nextBook;
            }
        }
        throw new BookStorageElementException("No such publication!");
    }

    /**
     * Adds publication to Set,  internally calls notifyAllObservers( publication,  message) method
     * after adding.
     *
     * @param publication
     * @throws BookStorageElementException
     */
    public void setStorageElement(Publication publication) throws BookStorageElementException {
        if (!storage.add(publication)) {
            throw new BookStorageElementException("Books already presents in storage!");
        }
        notifyAllObservers(publication, " - setting");
    }

    /**
     * Removes publication from Set,  internally calls notifyAllObservers( publication,  message) method
     * after removing.
     *
     * @param publication
     * @throws BookStorageElementException
     */
    public void removeStorageElement(Publication publication) throws BookStorageElementException {
        if (!storage.remove(publication)) {
            throw new BookStorageElementException("No such publication");
        }
        notifyAllObservers(publication, " - deleting");
    }

    /**
     * Counts size of storage
     *
     * @return int size-total size
     */
    public int getSize() {
        return storage.size();
    }

    /**
     * add Observer to the storage
     *
     * @param o-Observer
     */
    @Override
    public void register(by.tsvirko.task06.entity.observer.Observer o) {
        librarians.add(o);
        logger.info(o + "is working with publication storage");
    }

    /**
     * remove librarian from the storage
     *
     * @param o 0 Observer
     */
    @Override
    public void unregister(by.tsvirko.task06.entity.observer.Observer o) {
        librarians.remove(o);
        logger.info(o + "isn't working with publication storage");
    }

    /**
     * Notify all the registered librarians
     */
    @Override
    public void notifyAllObservers(Publication publication, String message) {
        for (Observer librarian : librarians) {
            librarian.update(publication, message);
        }
        System.out.println();
    }
}
