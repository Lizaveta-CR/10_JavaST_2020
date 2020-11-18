package task09.service.query.sort_query;

import by.tsvirko.task09.entity.composite.*;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import by.tsvirko.task09.service.query.sort_query.SortWordsInSentence;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortWordsInSentenceTest {
    private SortWordsInSentence service = new SortWordsInSentence();
    private TextStorageRepository storageRepository = RepositoryFactory.getInstance().getTextStorageRepository();

    @BeforeTest
    public void initText() throws FileServiceException, HandlerException {
        String text = new FileInitialization("input.txt").initialize();
        TextParser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));
        Composite compositeText = new Text();
        parser.parse(compositeText, text);
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        return new Object[]{
                "It has not but the only five also leap into survived centuries, remaining unchanged. electronic typesetting, essentially It in of of was the and with more with like there lease Lorem Ipsum Aldus Lorem Ipsum. sheets desktop Letraset passages, recently software versions PageMaker including containing publishing popularised\n" +
                        "\t\ta a a It is be by of at the its long fact that will page when reader layout. content looking readable distracted established a of is it of as to it The has that here, look like point using Ipsum using here', normal making letters, opposed content English. 'Content readable more-or-less distribution\n" +
                        "\t\ta a a It is be of at its fact that will page when reader layout. looking established\n" +
                        "\t\tBye."
        };
    }

    @Test(description = "Testing SortWordsInSentenceы' query() method",
            dataProvider = "composite_correct_data")
    public void testSort(String compos) {
        Composite composite = storageRepository.query(service);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }

    @Test(description = "Testing SortWordsInSentenceы' query() method")
    public void testSortLengthWords() {
        boolean wordLengthBooActual;
        Composite composite = storageRepository.query(service);
        int paragraphSize = composite.getSize();
        for (int i = 0; i < paragraphSize; i++) {
            Component sentence = (Component) composite.getChild(i);

            int sentenceSize = sentence.getSize();
            for (int j = 0; j < sentenceSize - 1; j++) {
                List<Component> words = new ArrayList<>();
                Component lexeme = (Component) sentence.getChild(j);
                int lexemeSize = lexeme.getSize();
                for (int k = 0; k < lexemeSize; k++) {
                    Component child = (Component) lexeme.getChild(k);
                    if (child instanceof Word) {
                        words.add(child);
                    }
                }
                int size = words.size();
                for (int w = 0; w < size - 1; w++) {
                    wordLengthBooActual = words.get(i).getSize() <= words.get(i + 1).getSize();
                    assertTrue(wordLengthBooActual);
                }
            }
        }
    }
}
