package by.tsvirko.task06.service.query.book_query.find_query;


import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.service.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FindTitleQuery implements Query<Book> {
    private String title;

    public FindTitleQuery(String title) {
        this.title = title;
    }

    @Override
    public List<Book> query(List<Book> storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            Book storageElement = storage.get(i);
            if (storageElement.getTitle().equals(title)) {
                result.add(storageElement);
            }
        }
        return result;
    }
}
