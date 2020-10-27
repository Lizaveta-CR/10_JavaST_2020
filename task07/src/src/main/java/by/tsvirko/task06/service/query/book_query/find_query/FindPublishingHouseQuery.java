package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds books in storage by given number of publishing house
 */
public class FindPublishingHouseQuery implements Query<Book, PublicationStorage> {
    private String publishingHouse;

    public FindPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public List<Book> query(PublicationStorage storage) throws FindException, BookStorageElementException {
        List<Book> result = new ArrayList<>();

        for (int i = 0; i < storage.getSize(); i++) {
            Publication publication = storage.getStorageElement(i);
            Book book = (Book) publication;
            if (book.getPublishingHouse() == publishingHouse) {
                result.add(book);
            }
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
