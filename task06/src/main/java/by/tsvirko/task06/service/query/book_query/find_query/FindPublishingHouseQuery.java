package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

public class FindPublishingHouseQuery implements Query<Book> {
    private String publishingHouse;

    public FindPublishingHouseQuery(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    @Override
    public List<Book> query(List<Book> storage) throws FindException {
        List<Book> result = new ArrayList<>();

        for (int i = 0; i < storage.size(); i++) {
            Book storageElement = storage.get(i);
            if (storageElement.getPublishingHouse() == publishingHouse) {
                result.add(storageElement);
            }
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
