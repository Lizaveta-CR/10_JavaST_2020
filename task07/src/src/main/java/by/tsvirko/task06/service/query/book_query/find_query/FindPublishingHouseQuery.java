package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;
/**
 * Finds books in storage by given number of publishing house
 */
public class FindPublishingHouseQuery implements Query<Book, BookStorage> {
    private String publishingHouse;

    public FindPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public List<Book> query(BookStorage storage) throws FindException, BookStorageElementException {
        List<Book> result = new ArrayList<>();

        for (int i = 0; i < storage.getSize(); i++) {
            Book storageElement = storage.getStorageElement(i);
            if (storageElement.getPublishingHouse() == publishingHouse) {
                result.add(storageElement);
            }
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
