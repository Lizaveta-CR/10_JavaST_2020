package task09.controller.command.impl;

import by.tsvirko.task09.controller.command.CommandName;
import by.tsvirko.task09.controller.command.impl.ParseCollectText;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class ParseCollectTextTest {
    private ParseCollectText parseCollectText = new ParseCollectText();
    private String text;

    @BeforeTest
    public void initText() throws FileServiceException {
        text = new FileInitialization("input.txt").initialize();
    }

    @Test(description = "Testing ParseCollectTexts' execute() method")
    public void testCollectWithNumbers() {
        List<String> strings = new ArrayList<>();
        strings.add(CommandName.PARSE_TEXT.name());
        strings.add("input.txt");
        Optional<String> actual = parseCollectText.execute(strings);
        String expected = text;
        assertEquals(actual.get(), expected);
    }
}
