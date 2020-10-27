package by.tsvirko.task06.service.query.book_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds books in storage by given author
 */
public class FindAuthorsQuery implements Query<Book, PublicationStorage> {
    private String author;

    public FindAuthorsQuery(String authors) {
        this.author = authors;
    }

    @Override
    public List<Book> query(PublicationStorage storage) throws FindException, BookStorageElementException {
        List<Book> result = new ArrayList<>();
        for (int i = 0; i < storage.getSize(); i++) {
            Publication storageElement = storage.getStorageElement(i);
            Book book = (Book) storageElement;
            for (int j = 0; j < book.getAuthorsSize(); j++) {
                try {
                    if (book.getAuthor(j).equals(author)) {
                        result.add(book);
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
