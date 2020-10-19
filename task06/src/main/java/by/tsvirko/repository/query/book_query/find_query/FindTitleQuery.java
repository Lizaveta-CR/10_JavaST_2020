package by.tsvirko.repository.query.book_query.find_query;


import by.tsvirko.dao.exception.BookStorageElementException;
import by.tsvirko.entity.Book;
import by.tsvirko.entity.BookStorage;
import by.tsvirko.repository.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FindTitleQuery implements Query<Book, BookStorage> {
    private String title;

    public FindTitleQuery(String title) {
        this.title = title;
    }

    @Override
    public List<Book> query(BookStorage storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.getSize(); i++) {
            Book storageElement = storage.getStorageElement(i);
            if (storageElement.getTitle().equals(title)) {
                result.add(storageElement);
            }
        }
        return result;
    }
}
