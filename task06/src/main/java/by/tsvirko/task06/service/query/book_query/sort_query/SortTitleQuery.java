package by.tsvirko.task06.service.query.book_query.sort_query;


import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;

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
