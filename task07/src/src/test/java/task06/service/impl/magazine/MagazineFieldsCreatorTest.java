package task06.service.impl.magazine;

import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.impl.book.BookFieldsCreator;
import by.tsvirko.task06.service.impl.magazine.MagazineFieldsCreator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MagazineFieldsCreatorTest {
    private MagazineFieldsCreator magazineFieldsCreator = new MagazineFieldsCreator();

    @DataProvider(name = "correctData")
    public Object[] createCorrectData() {
        return new Object[]{
                Arrays.asList("title", "numberOfPages", "year", "publishingHouse", "coverHeading")
        };
    }

    @Test(description = "Correct scenery of the creating books",
            dataProvider = "correctData")
    public void testCreating(List<String> fields) throws ServiceInitException {
        StringBuilder actual = magazineFieldsCreator.getPublicationFields();
        ArrayList<String> actualArrayList = new ArrayList<>();
        String[] split = actual.toString().split(" ");
        for (int i = 0; i < split.length; i++) {
            actualArrayList.add(split[i]);
        }
        List<String> expected = fields;
        assertEquals(actualArrayList, expected);
    }
}
