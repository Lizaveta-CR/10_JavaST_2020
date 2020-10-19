package by.tsvirko.repository.query.book_query.sort_query;


import by.tsvirko.dao.exception.BookStorageElementException;
import by.tsvirko.entity.Book;
import by.tsvirko.entity.BookStorage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTitleQuery extends AbstractSortQuery {
    @Override
    public List<Book> query(BookStorage storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.getSize(); i++) {
            result.add(storage.getStorageElement(i));
        }
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);

        if (isDescending()) {
            comparator = comparator.reversed();
        }
        result.sort(comparator);
        return result;
    }
}
