package task06.service.query.find_query;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.PublicationStorage;
import by.tsvirko.task06.repository.exception.BookStorageElementException;
import by.tsvirko.task06.service.query.publication_query.find_query.FindByIdPublicationQuery;
import by.tsvirko.task06.service.query.publication_query.find_query.FindByNumOfPagesPublicationQuery;
import by.tsvirko.task06.service.query.publication_query.find_query.exception.FindException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FindByNumOfPagesPublicationQueryTest {
    private FindByNumOfPagesPublicationQuery query;
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

    @DataProvider(name = "correctData")
    public Object[][] correctDataAnswer() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[][]{
                {"200", Arrays.asList(new Book("Title", 200, 2020, "USAPublication",
                                authors)
                        , new Magazine("Title", 200, 2020, "USAPublication",
                                "gloss"))}};
    }

    @DataProvider(name = "incorrectData")
    public Object[] incorrectDataAnswer() {
        return new Object[]{
                "128", "3ii2", null};
    }

    @Test(description = "testing finding by pages", dataProvider = "correctData")
    public void testPagesCorrect(String pages, List<Publication> publication) throws FindException {
        this.query = new FindByNumOfPagesPublicationQuery(pages);
        List<Publication> actual = this.query.query(storage);
        List<Publication> expected = publication;
        assertEquals(actual, expected);
    }

    @Test(description = "testing finding by pages", dataProvider = "incorrectData")
    public void testPagesIncorrect(String page) {
        this.query = new FindByNumOfPagesPublicationQuery(page);
        assertThrows(FindException.class, () -> query.query(storage));
    }
}
