package task06.service.impl.magazine;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Magazine;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.exception.ServiceInitException;
import by.tsvirko.task06.service.impl.book.BookCreator;
import by.tsvirko.task06.service.impl.magazine.MagazineCreator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class MagazineCreatorTest {
    private MagazineCreator magazineCreator = new MagazineCreator();

    @DataProvider(name = "correctDataForCreating")
    public Object[][] createCorrectData() {
        Set<String> authors = new HashSet<>();
        authors.add("J.K.Rowling");
        return new Object[][]{
                {Arrays.asList("Title", "200", "2020", "USAPublication", "gloss"), new Magazine("Title", 200,
                        2020, "USAPublication",
                        "gloss")},
        };
    }

    @DataProvider(name = "incorrectDataForCreating")
    public Object[] createIncorrectData() {
        return new Object[]{
                Arrays.asList("Title", "-1", "-2020", "USAPublication", "gloss")
                , Arrays.asList(null, "689", "2021", null, "gloss")
                , Arrays.asList("USAPublication")
        };
    }

    @Test(description = "Correct scenery of the creating books",
            dataProvider = "correctDataForCreating")
    public void testCreating(List<String> fields, Publication magazine) throws ServiceInitException {
        Publication actual = magazineCreator.create(fields);
        Publication expected = magazine;
        assertEquals(actual, expected);
    }

    @Test(description = "Incorrect scenery of the creating books",
            dataProvider = "incorrectDataForCreating")
    public void testCreatingIncorrect(List<String> fields) {
        assertThrows(ServiceInitException.class, () -> new MagazineCreator().create(fields));
    }
}
