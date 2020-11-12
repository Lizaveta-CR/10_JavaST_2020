package task09.service;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Lexeme;
import by.tsvirko.task09.entity.composite.Sentence;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.CharacterParser;
import by.tsvirko.task09.service.chainOfResponsibility.LexemeParser;
import by.tsvirko.task09.service.chainOfResponsibility.SentenceParser;
import by.tsvirko.task09.service.chainOfResponsibility.WordParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LexemeParserTest {
    private LexemeParser parser = new LexemeParser(new WordParser(new CharacterParser()));
    private String text;

    @BeforeTest
    public void initText() {
        text = new FileInitialization("input.txt").initialize();
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        return new Object[]{
                " It has survived not only five centuries, but also the leap into electronic typesetting, "
                        + "remaining essentially unchanged."
                        + " It was popularised in the with there lease of Letraset sheets containing Lorem"
                        + " Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker "
                        + "including versions of Lorem Ipsum."
                        + " It is a long established fact that a reader will be distracted by the readable content"
                        + " of a page when looking at its layout."
                        + " The point of using Ipsum is that it has a more-or-less normal distribution of letters,"
                        + " as opposed to using 'Content here, content here', making it look like readable English."
                        + " It is a established fact that a reader will be of a page when looking at its layout."
                        + " Bye."
        };
    }

    @Test(description = "Testing TextParsers' parse() and collect() method",
            dataProvider = "composite_correct_data")
    public void testCollect(String compos) {
        Composite compositeLexeme = new Lexeme();
        Composite composite = parser.parse(compositeLexeme, text);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }
}
