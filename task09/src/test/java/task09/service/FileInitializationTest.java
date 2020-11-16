package task09.service;

import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FileInitializationTest {
    private FileInitialization initialization = new FileInitialization();

    @DataProvider(name = "correct_file_data")
    public Object[] createCorrectData() {
        return new Object[]{
                "\t\tIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with there lease of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\t\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\n" +
                        "\t\tIt is a established fact that a reader will be of a page when looking at its layout.\n" +
                        "\t\tBye."
        };
    }

    @Test(description = "Testing FileInitializations' initialize() method",
            dataProvider = "correct_file_data")
    public void testInitializeCorrect(String text) throws FileServiceException {
        initialization.setFilename("input.txt");
        String actual = initialization.initialize();
        String expected = text;
        assertEquals(actual, expected);
    }

    @Test(description = "Testing FileInitializations' initialize() method with wrong file name")
    public void testInitializeWrongFileName() {
        initialization.setFilename("wrong.txt");
        assertThrows(FileServiceException.class, () -> initialization.initialize());
    }

    @Test(description = "Testing FileInitializations' initialize() method with empty file")
    public void testInitializeEmpty() {
        initialization.setFilename("empty.txt");
        assertThrows(FileServiceException.class, () -> initialization.initialize());
    }
}
