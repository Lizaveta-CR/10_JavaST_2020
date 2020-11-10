package task09.service;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.ParagraphParser;
import by.tsvirko.task09.service.chainOfResponsibility.TextParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextParserTest {
    private TextParser parser = new TextParser(new ParagraphParser());
    private String text;

    @BeforeTest
    public void initText() {
        text = new FileInitialization("input.txt").initialize();
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        //TODO:
        return new Object[]{};
    }

    @Test(description = "Testing TextParsers' parse() method",
            dataProvider = "composite_correct_data")
    public void testSum(String compos) {
        Composite composite = new Text();
        Composite actual = parser.parse(composite, text);
        String expected = compos;
        assertEquals(actual.toString(), expected);
    }
}
