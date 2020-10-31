package task06.service.impl.book;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.impl.book.BookCreator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class BookCreatorTest {
    private BookCreator bookCreator = new BookCreator();

    @DataProvider(name = "correctDataForCreating")
    public Object[][] createCorrectData() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[][]{
                {Arrays.asList("Title", "200", "2020", "USAPublication", "J.K.Rowling"), new Book("Title", 200,
                        2020, "USAPublication",
                        authors)},
        };
    }

    @DataProvider(name = "incorrectDataForCreating")
    public Object[] createIncorrectData() {
        return new Object[]{
                Arrays.asList("Title", "-1", "-2020", "USAPublication", "J.K.Rowling")
                , Arrays.asList(null, "689", "2021", null, "Hamlet")
                , Arrays.asList("USAPublication", null)

        };
    }

    @Test(description = "Correct scenery of the creating books",
            dataProvider = "correctDataForCreating")
    public void testCreating(List<String> fields, Publication book) throws ServiceInitException {
        Publication actual = bookCreator.create(fields);
        Publication expected = book;
        assertEquals(actual, expected);
    }

    @Test(description = "Incorrect scenery of the creating books",
            dataProvider = "incorrectDataForCreating")
    public void testCreatingIncorrect(List<String> fields) {
        assertThrows(ServiceInitException.class, () -> new BookCreator().create(fields));
    }
}
