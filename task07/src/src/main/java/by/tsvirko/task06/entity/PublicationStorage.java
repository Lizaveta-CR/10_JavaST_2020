package by.tsvirko.task06.entity;

import by.tsvirko.task06.repository.exception.BookStorageElementException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class to store books - Singleton
 */
public class PublicationStorage {
    private static PublicationStorage instance;
    private Set<Publication> storage = new HashSet<>();

    private PublicationStorage() {
    }

    public static PublicationStorage getInstance() {
        return (instance == null) ? instance = new PublicationStorage() : instance;
    }

    public Publication getStorageElement(int i) throws BookStorageElementException {
        try {
            return new ArrayList<>(storage).get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new BookStorageElementException("No such book!");
        }
    }

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

    public void setStorageElement(Publication book) throws BookStorageElementException {
        if (!storage.add(book)) {
            throw new BookStorageElementException("Books already presents in storage!");
        }
    }

    public void removeStorageElement(Publication book) throws BookStorageElementException {
        if (!storage.remove(book)) {
            throw new BookStorageElementException("No such book");
        }
    }

    public int getSize() {
        return storage.size();
    }
}
