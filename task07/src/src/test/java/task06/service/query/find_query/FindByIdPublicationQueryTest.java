package task06.service.query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.publication_query.find_query.FindByIdPublicationQuery;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FindByIdPublicationQueryTest {
    private FindByIdPublicationQuery query;
    private PublicationStorage storage = PublicationStorage.getInstance();

    @BeforeTest
    public void initStorage() throws BookStorageElementException {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        Book book = new Book("Title", 200, 2020, "USAPublication",
                authors);
        book.setId("1");
        storage.setStorageElement(book);
        Magazine magazine = new Magazine("Title", 200, 2020, "USAPublication",
                "gloss");
        magazine.setId("2");
        storage.setStorageElement(magazine);
        System.out.println("Storage has been initialized");
    }

    @DataProvider(name = "correctData")
    public Object[][] correctDataAnswer() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[][]{
                {"1", new Book("Title", 200, 2020, "USAPublication",
                        authors)
                }};
    }

    @DataProvider(name = "incorrectData")
    public Object[] incorrectDataAnswer() {
        return new Object[]{
                "128", "3ii2", null};
    }

    @Test(description = "testing finding by id", dataProvider = "correctData")
    public void testIdCorrect(String id, Book publication) throws FindException {
        this.query = new FindByIdPublicationQuery(id);
        List<Publication> actual = this.query.query(storage);
        Book expected = publication;
        assertEquals(actual.get(0), expected);
    }

    @Test(description = "testing finding by id", dataProvider = "incorrectData")
    public void testPagesIncorrect(String id) {
        this.query = new FindByIdPublicationQuery(id);
        assertThrows(FindException.class, () -> query.query(storage));
    }
}
