package by.tsvirko.task06.service.query.publication_query.find_query;

import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds publication by title
 */
public class FindByTitlePublicationQuery implements Query<Publication, PublicationStorage> {
    private String title;

    public FindByTitlePublicationQuery(String title) {
        this.title = title;
    }

    @Override
    public List<Publication> query(PublicationStorage storage) throws FindException {
        List<Publication> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.getSize(); i++) {
                Publication storageElement = storage.getStorageElement(i);
                if (storageElement.getTitle().equals(title)) {
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