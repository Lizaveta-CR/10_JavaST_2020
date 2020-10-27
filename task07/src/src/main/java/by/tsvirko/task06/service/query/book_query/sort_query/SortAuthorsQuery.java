package by.tsvirko.task06.service.query.book_query.sort_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.entity.exception.NoAuthorsException;
import by.tsvirko.task06.repository.exception.BookStorageElementException;

import java.util.*;

/**
 * Sorts bookStorage by authors
 */
public class SortAuthorsQuery extends AbstractSortQuery {
    @Override
    public List<Book> query(PublicationStorage storage) throws BookStorageElementException {
        List<Book> result = new ArrayList<>();
        Map<String, Book> map = new TreeMap<>();

        for (int i = 0; i < storage.getSize(); i++) {
            Publication publication = storage.getStorageElement(i);
            Book book = (Book) publication;
            try {
                map.put(book.getAuthor(0), book);
            } catch (NoAuthorsException e) {
                throw new BookStorageElementException();
            }
        }
        //LinkedHashMap preserve the ordering of elements in which they are inserted
        Map<String, Book> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        if (isDescending()) {
            map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        }

        for (Map.Entry<String, Book> entry : sortedMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
