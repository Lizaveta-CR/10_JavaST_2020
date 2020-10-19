package by.tsvirko.entity;

import by.tsvirko.dao.exception.BookStorageElementException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BookStorage {
    private static BookStorage instance;
    private Set<Book> storage = new HashSet<>();

    private BookStorage() {
    }

    public static BookStorage getInstance() {
        return (instance == null) ? instance = new BookStorage() : instance;
    }

    public Book getStorageElement(int i) throws BookStorageElementException {
        try {
            return new ArrayList<>(storage).get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new BookStorageElementException("No such book!");
        }
    }

    public void setStorageElement(Book book) throws BookStorageElementException {
        if (!storage.add(book)) {
            throw new BookStorageElementException("Books already presents in storage!");
        }
    }

    public void removeStorageElement(Book book) throws BookStorageElementException {
        if (!storage.remove(book)) {
            throw new BookStorageElementException("No such book");
        }
    }

    public int getSize() {
        return storage.size();
    }
}
