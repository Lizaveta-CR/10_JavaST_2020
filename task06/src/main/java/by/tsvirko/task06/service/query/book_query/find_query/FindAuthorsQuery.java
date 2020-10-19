package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

public class FindAuthorsQuery implements Query<Book> {
    private String author;

    public FindAuthorsQuery(String authors) {
        this.author = authors;
    }

    @Override
    public List<Book> query(List<Book> storage) throws FindException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.size(); i++) {
            Book storageElement = storage.get(i);
            for (int j = 0; j < storageElement.getAuthorsSize(); j++) {
                try {
                    if (storageElement.getAuthor(j).equals(author)) {
                        result.add(storageElement);
                    }
                } catch (NoAuthorsException | IndexOutOfBoundsException e) {
                    throw new FindException(e.getCause());
                }
            }
        }
        if (result.isEmpty()) {
            throw new FindException();
        } else {
            return result;
        }
    }
}
