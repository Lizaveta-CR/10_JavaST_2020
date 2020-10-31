package task06.repository.impl;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.repository.impl.PublicationRepositoryImpl;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.impl.book.BookCreator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertThrows;

public class PublicationRepositoryImplTest {
    private PublicationRepositoryImpl publicationRepository = new PublicationRepositoryImpl();

    private PublicationStorage storage = PublicationStorage.getInstance();

    @BeforeTest
    public void initStorage() throws BookStorageElementException {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        Book book = new Book("Title", 200, 2020, "USAPublication",
                authors);
        storage.setStorageElement(book);
        Magazine magazine = new Magazine("Title", 200, 2020, "USAPublication",
                "gloss");
        storage.setStorageElement(magazine);
        System.out.println("Storage has been initialized");
    }

    @DataProvider(name = "publicationExists_data")
    public Object[] createDataExist() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[]{
                new Book("Title", 200, 2020, "USAPublication",
                        authors),
                new Magazine("Title", 200, 2020, "USAPublication",
                        "gloss")
        };
    }

    @DataProvider(name = "publicationNotExists_data")
    public Object[] createDataNotExist() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[]{
                new Book("Title", 123, 2000, "USAPublication",
                        authors),
                new Magazine("Title", 200, 1983, "USAPublication",
                        "gloss")
        };
    }

    @DataProvider(name = "publicationUpdate_data")
    public Object[][] createDataUpdate() {
        return new Object[][]{
                {new Magazine("Title", 200, 1983, "USAPublication",
                        "gloss"), new Magazine("Title", 200, 1983, "USAPublication",
                        "gloss")}
        };
    }

    @Test(description = "testing addPublication method, we expect BookStorageElementException"
            + " when there is such element", dataProvider = "publicationExists_data")
    public void testAddPublication(Publication publication) {
        assertThrows(BookStorageElementException.class, () -> publicationRepository.addPublication(publication));
    }

    @Test(description = "testing removePublication method, we expect BookStorageElementException"
            + " when there is no such element", dataProvider = "publicationNotExists_data")
    public void testRemovePublication(Publication publication) {
        assertThrows(BookStorageElementException.class, () -> publicationRepository.removePublication(publication));
    }

    @Test(description = "testing updatePublication method, we expect BookStorageElementException"
            + " when elements are same", dataProvider = "publicationUpdate_data")
    public void testUpdatePublication(Publication publicationOld, Publication publicationNew) {
        assertThrows(BookStorageElementException.class, () -> publicationRepository
                .updatePublication(publicationOld, publicationNew));
    }

    @Test(description = "testing getPublication method, we expect BookStorageElementException"
            + " when there is no such same", dataProvider = "publicationNotExists_data")
    public void testGetPublication(Publication publication) {
        assertThrows(BookStorageElementException.class, () -> publicationRepository
                .getPublication(publication));
    }
}
