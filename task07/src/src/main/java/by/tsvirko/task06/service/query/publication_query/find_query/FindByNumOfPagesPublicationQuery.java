package by.tsvirko.task06.service.query.publication_query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Finds publication by number of pages
 */
public class FindByNumOfPagesPublicationQuery implements Query<Publication, PublicationStorage> {
    private String pages;

    public FindByNumOfPagesPublicationQuery(String pages) {
        this.pages = pages;
    }

    @Override
    public List<Publication> query(PublicationStorage storage) throws FindException {
        List<Publication> result = new ArrayList<>();
        try {
            for (int i = 0; i < storage.getSize(); i++) {
                Publication storageElement = storage.getStorageElement(i);
                if (storageElement.getNumberOfPages() == Integer.parseInt(pages)) {
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

    public static void main(String[] args) throws BookStorageElementException, FindException {
        FindByNumOfPagesPublicationQuery find = new FindByNumOfPagesPublicationQuery("200");
        PublicationStorage storage = PublicationStorage.getInstance();

        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        Book book = new Book("Title", 200, 2020, "USAPublication",
                authors);
        storage.setStorageElement(book);
        Magazine magazine = new Magazine("Title", 200, 2020, "USAPublication",
                "gloss");
        storage.setStorageElement(magazine);
//        System.out.println(find.query(storage));
        List<Publication> query = find.query(storage);
        List<Publication> objects = new ArrayList<>();
        Book book1 = new Book("Title", 200, 2020, "USAPublication",
                authors);
        Magazine magazine1 = new Magazine("Title", 200, 2020, "USAPublication",
                "gloss");
        objects.add(book1);
        objects.add(magazine1);

        System.out.println(query.equals(objects));
    }
}
