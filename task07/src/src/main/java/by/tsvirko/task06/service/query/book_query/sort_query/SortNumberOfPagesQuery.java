package by.tsvirko.task06.service.query.book_query.sort_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts bookStorage by NumberOfPages
 */
public class SortNumberOfPagesQuery extends AbstractSortQuery {
    @Override
    public List<Book> query(PublicationStorage storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.getSize(); i++) {
            result.add((Book) storage.getStorageElement(i));
        }
        Comparator<Book> comparator = Comparator.comparing(Book::getNumberOfPages);

        if (isDescending()) {
            comparator = comparator.reversed();
        }
        result.sort(comparator);
        return result;
    }
}
