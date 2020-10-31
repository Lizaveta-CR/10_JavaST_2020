package by.tsvirko.task06.service.query.publication_query.sort_query;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Sorts publication by number of pages
 */
public class SortNumOfPagesQuery extends AbstractSortQuery {

    @Override
    public List<Publication> query(PublicationStorage storage) throws BookStorageElementException {
        List<Publication> result = new ArrayList<>();

        int size = storage.getSize();
        for (int i = 0; i < size; i++) {
            Publication storageElement = storage.getStorageElement(i);
            result.add(storageElement);
        }

        for (int i = 0; i < size; i++) {
            storage.removeStorageElement(result.get(i));
        }

        Comparator<Publication> comparator = Comparator.comparing(Publication::getNumberOfPages);

        if (isDescending()) {
            comparator = comparator.reversed();
        }
        result.sort(comparator);
        for (int i = 0; i < result.size(); i++) {
            storage.setStorageElement(result.get(i));
        }
        return result;
    }
}


