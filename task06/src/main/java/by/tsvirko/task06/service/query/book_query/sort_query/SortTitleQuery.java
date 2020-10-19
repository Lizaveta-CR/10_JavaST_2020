package by.tsvirko.task06.service.query.book_query.sort_query;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTitleQuery extends AbstractSortQuery {

    @Override
    public List<Book> query(List<Book> storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            result.add(storage.get(i));
        }
        Comparator<Book> comparator = Comparator.comparing(Book::getTitle);

        if (isDescending()) {
            comparator = comparator.reversed();
        }
        result.sort(comparator);
        return result;
    }
}
