package task06.service.impl.book;

import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.impl.book.BookFieldsCreator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class BookFieldsCreatorTest {
    private BookFieldsCreator bookFieldsCreator = new BookFieldsCreator();

    @DataProvider(name = "correctData")
    public Object[] createCorrectData() {
        return new Object[]{
                Arrays.asList("title", "numberOfPages", "year", "publishingHouse", "authors"
                )
        };
    }

    @Test(description = "Correct scenery of the creating books",
            dataProvider = "correctData")
    public void testCreating(List<String> fields) throws ServiceInitException {
        StringBuilder actual = bookFieldsCreator.getPublicationFields();
        ArrayList<String> actualArrayList = new ArrayList<>();
        String[] split = actual.toString().split(" ");
        for (int i = 0; i < split.length; i++) {
            actualArrayList.add(split[i]);
        }
        List<String> expected = fields;
        assertEquals(actualArrayList, expected);
    }
}
