package task09.service.query.sort_query;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import by.tsvirko.task09.service.query.sort_query.SortParagraphsBySentences;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortParagraphsBySentencesTest {
    private SortParagraphsBySentences service = new SortParagraphsBySentences();
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
                "Bye.\n" +
                        "\t\tIt is a established fact that a reader will be of a page when looking at its layout.\n" +
                        "\t\tIt has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with there lease of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\t\tIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
        };
    }

    @Test(description = "Testing SortParagraphsBySentences' query() method",
            dataProvider = "composite_correct_data")
    public void testSort(String compos) {
        Composite composite = storageRepository.query(service);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }
}
