package task09.controller.command.impl;

import by.tsvirko.task09.controller.command.CommandName;
import by.tsvirko.task09.controller.command.impl.SortParagraphsBySentencesCommand;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class SortParagraphsBySentencesCommandTest {
    private SortParagraphsBySentencesCommand sort = new SortParagraphsBySentencesCommand();

    @BeforeTest
    public void initText() throws FileServiceException, HandlerException {
        String text = new FileInitialization("input.txt").initialize();
        Parser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));
        Composite compositeText = new Text();
        parser.parse(compositeText, text);
    }

    @Test(description = "Testing SortLexemesBySymbols' execute() method")
    public void testCollectWithNumbers() {
        List<String> strings = new ArrayList<>();
        strings.add(CommandName.PARAGRAPH_BY_SENTENCES.name());
        Optional<String> actual = sort.execute(strings);
        String expected = "Sorting has been done";
        assertEquals(actual.get(), expected);
    }
}
