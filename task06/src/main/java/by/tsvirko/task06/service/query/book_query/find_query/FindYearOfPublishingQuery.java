package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

public class FindYearOfPublishingQuery implements Query<Book> {
    private String year;

    public FindYearOfPublishingQuery(String year) {
        this.year = year;
    }

    @Override
    public List<Book> query(List<Book> storage) throws FindException {
        List<Book> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.size(); i++) {
                Book storageElement = storage.get(i);
                if (storageElement.getYearOfPublishing() == Integer.parseInt(year)) {
                    result.add(storageElement);
                }
            }
        } catch (NumberFormatException e) {
            throw new FindException("Invalid input parametres");
        }
        if (result.isEmpty()) {
            throw new FindException("No result");
        } else {
            return result;
        }
    }
}
