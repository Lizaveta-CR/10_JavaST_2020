package task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private TextParser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));
    private String text;

    @BeforeTest
    public void initText() {
        text = new FileInitialization("input.txt").initialize();
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        return new Object[]{
                "\t\tIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with there lease of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\t\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\n" +
                        "\t\tIt is a established fact that a reader will be of a page when looking at its layout.\n" +
                        "\t\tBye."
        };
    }

    @Test(description = "Testing TextParsers' parse() and collect() method",
            dataProvider = "composite_correct_data")
    public void testCollect(String compos) {
        Composite compositeText = new Text();
        Composite composite = parser.parse(compositeText, text);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }
}
