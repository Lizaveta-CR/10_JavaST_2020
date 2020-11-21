package task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private TextParser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));
    private String text;

    public void initTextNoNumbers(String filename) throws FileServiceException {
        text = new FileInitialization(filename).initialize();
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        return new Object[]{
                "\t\tIt 1213 (five) has survived - not only centuries, but also the leap into 52 electronic typesetting, remaining 3 essentially 9 unchanged. It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\t\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
                        "\t\tIt is a established fact that a reader will be of a page when looking at its layout.\n" +
                        "\t\tBye."
        };
    }

    @Test(description = "Testing TextParsers' parse() and collect() method")
    public void testCollectNoNumbers() throws HandlerException, FileServiceException {
        initTextNoNumbers("input.txt");
        Composite compositeText = new Text();
        Composite composite = parser.parse(compositeText, text);
        String actual = composite.collect();
        assertEquals(actual, text);
    }

    @Test(description = "Testing TextParsers' parse() and collect() method",
            dataProvider = "composite_correct_data")
    public void testCollectWithNumbers(String text) throws HandlerException, FileServiceException {
        initTextNoNumbers("inputWithNumbers.txt");
        Composite compositeText = new Text();
        Composite composite = parser.parse(compositeText, text);
        String actual = text;
        assertEquals(actual, text);
    }
}
