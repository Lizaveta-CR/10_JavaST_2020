package by.tsvirko.task06.service.query.book_query.sort_query;

import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortYearOfPublishingQuery extends AbstractSortQuery {
    @Override
    public List<Book> query(BookStorage storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.getSize(); i++) {
            result.add(storage.getStorageElement(i));
        }
        Comparator<Book> comparator = Comparator.comparing(Book::getYearOfPublishing);

        if (isDescending()) {
            comparator = comparator.reversed();
        }
        result.sort(comparator);
        return result;
    }
}
