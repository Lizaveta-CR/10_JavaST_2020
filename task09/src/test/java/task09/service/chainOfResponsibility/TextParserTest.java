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

    @BeforeTest
    public void initText() throws FileServiceException {
        text = new FileInitialization("input.txt").initialize();
    }

    @Test(description = "Testing TextParsers' parse() and collect() method")
    public void testCollect() throws HandlerException {
        Composite compositeText = new Text();
        Composite composite = parser.parse(compositeText, text);
        String actual = composite.collect();
        assertEquals(actual, text);
    }
}
