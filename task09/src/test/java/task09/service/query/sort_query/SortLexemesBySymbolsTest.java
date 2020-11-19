package task09.service.query.sort_query;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import by.tsvirko.task09.service.query.sort_query.SortLexemesBySymbols;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SortLexemesBySymbolsTest {
    private SortLexemesBySymbols service;
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
        return new Object[][]{
                {'i', " distribution containing including publishing remaining English centuries distracted electronic" +
                        " essentially established established five in into is is is it it its its like like looking " +
                        "looking making point popularised survived typesetting using using versions will will with with " +
                        "'Content Aldus Bye Ipsum Ipsum Ipsum It It It It Letraset Lorem Lorem PageMaker The a a a a a " +
                        "a a also and as at at be be but by content content desktop fact fact has has here here' layout" +
                        " layout leap lease letters long look more more-or-less normal not of of of of of of only opposed " +
                        "page page passages readable readable reader reader recently sheets software that that that the " +
                        "the the there to unchanged was when when"}
        };
    }

    @DataProvider(name = "symbol_data")
    public Object[] symbolData() {
        return new Object[]{
                'i'
        };
    }

    @Test(description = "Testing SortLexemesBySymbols' query() method",
            dataProvider = "composite_correct_data")
    public void testSort(char symbol, String compos) {
        service = new SortLexemesBySymbols(symbol);
        Composite composite = storageRepository.query(service);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }

    @Test(description = "Testing SortLexemesBySymbols' query() method",
            dataProvider = "symbol_data")
    public void testSortFreqChars(char symbol) {
        service = new SortLexemesBySymbols(symbol);
        boolean charFreqBooActual = false;
        Composite composite = storageRepository.query(service);
        int lexemesSize = composite.getSize();
        for (int i = 0; i < lexemesSize; i++) {
            Component lexeme = (Component) composite.getChild(i);

            int size = lexeme.getSize();
            for (int j = 0; j < size - 1; j++) {
                Component wordFirst = (Component) lexeme.getChild(j);
                int charFirstFreq = 0;

                Component wordSec = (Component) lexeme.getChild(j + 1);
                int charSecFreq = 0;

                int wordFirstSize = wordFirst.getSize();
                for (int w1 = 0; w1 < wordFirstSize; w1++) {
                    if (((Component) wordFirst.getChild(w1)).getChild(0).equals(symbol)) {
                        charFirstFreq++;
                    }
                }
                for (int w2 = 0; w2 < wordFirstSize; w2++) {
                    if (((Component) wordSec.getChild(w2)).getChild(0).equals(symbol)) {
                        charSecFreq++;
                    }
                }
                charFreqBooActual = charFirstFreq >= charSecFreq;
                assertTrue(charFreqBooActual == true);
            }
        }
    }

    @Test(description = "Testing SortLexemesBySymbols' query() method",
            dataProvider = "symbol_data")
    public void testSortAlphabeticChars(char symbol) {
        service = new SortLexemesBySymbols(symbol);
        boolean charFreqBooActual = false;
        Composite composite = storageRepository.query(service);
        int lexemesSize = composite.getSize();
        for (int i = 0; i < lexemesSize - 1; i++) {
            Component lexemeFirst = (Component) composite.getChild(i);
            Component lexemeSec = (Component) composite.getChild(i + 1);

            if (findSymbolFrequency(lexemeFirst, symbol) == findSymbolFrequency(lexemeSec, symbol)) {
                String collectFirst = (String) lexemeFirst.collect();
                String collectSec = (String) lexemeSec.collect();

                charFreqBooActual = collectFirst.compareTo(collectSec) <= 0;
                assertTrue(charFreqBooActual == true);
            }

        }
    }

    private int findSymbolFrequency(Component lexeme, char symbol) {
        int frequency = 0;
        int lexemeSize = lexeme.getSize();

        for (int i = 0; i < lexemeSize; i++) {
            Component character = (Component) lexeme.getChild(i);
            int characterSize = character.getSize();

            for (int k = 0; k < characterSize; k++) {
                Component leaf = (Component) character.getChild(k);
                if ((leaf.getChild(0)).equals(symbol)) {
                    frequency++;
                }
            }
        }
        return frequency;
    }
}
