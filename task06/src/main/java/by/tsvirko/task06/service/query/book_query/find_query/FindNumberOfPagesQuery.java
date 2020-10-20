package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.BookStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds books in storage by given number of pages
 */
public class FindNumberOfPagesQuery implements Query<Book, BookStorage> {
    private String pages;

    public FindNumberOfPagesQuery(String pages) {
        this.pages = pages;
    }

    @Override
    public List<Book> query(BookStorage storage) throws FindException {
        List<Book> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.getSize(); i++) {
                Book storageElement = storage.getStorageElement(i);
                if (storageElement.getNumberOfPages() == Integer.parseInt(pages)) {
                    result.add(storageElement);
                }
            }
        } catch (NumberFormatException | BookStorageElementException e) {
            throw new FindException();
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
