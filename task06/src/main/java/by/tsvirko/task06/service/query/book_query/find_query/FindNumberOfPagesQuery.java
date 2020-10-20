package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

public class FindNumberOfPagesQuery implements Query<Book> {
    private String pages;

    public FindNumberOfPagesQuery(String pages) {
        this.pages = pages;
    }

    @Override
    public List<Book> query(List<Book> storage) throws FindException {
        List<Book> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.size(); i++) {
                Book storageElement = storage.get(i);
                if (storageElement.getNumberOfPages() == Integer.parseInt(pages)) {
                    result.add(storageElement);
                }
            }
        } catch (NumberFormatException e) {
            throw new FindException();
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
