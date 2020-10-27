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
 * Finds books in storage by given year of publishing
 */
public class FindYearOfPublishingQuery implements Query<Book, PublicationStorage> {
    private String year;

    public FindYearOfPublishingQuery(String year) {
        this.year = year;
    }

    @Override
    public List<Book> query(PublicationStorage storage) throws FindException {
        List<Book> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.getSize(); i++) {
                Publication publication = storage.getStorageElement(i);
                Book book = (Book) publication;
                if (book.getYearOfPublishing() == Integer.parseInt(year)) {
                    result.add(book);
                }
            }
        } catch (NumberFormatException | BookStorageElementException e) {
            throw new FindException("Invalid input parametres");
        }
        if (result.isEmpty()) {
            throw new FindException("No result");
        } else {
            return result;
        }
    }
}
