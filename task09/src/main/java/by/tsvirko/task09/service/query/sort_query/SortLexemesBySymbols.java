package by.tsvirko.task09.service.query.sort_query;

import by.tsvirko.task09.entity.TextStorage;
import by.tsvirko.task09.entity.composite.*;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class SortLexemesBySymbols extends AbstractSortQuery {
    private static final Logger logger = LogManager.getLogger(SortLexemesBySymbols.class);

    private char symbol;

    public SortLexemesBySymbols(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public Composite query(TextStorage textStorage) {
        Composite paragraph = (Composite) textStorage.getComponent(0);

        List<Component> lexemes = new ArrayList<>();
        Composite paragraphList = new Paragraph();
        int paragraphSize = paragraph.getSize();
        for (int i = 0; i < paragraphSize; i++) {
            Component sentence = (Component) paragraph.getChild(i);

            int sentenceSize = sentence.getSize();
            for (int j = 0; j < sentenceSize; j++) {
                Component lexeme = (Component) sentence.getChild(j);
                int lexemeSize = lexeme.getSize();

                for (int k = 0; k < lexemeSize; k++) {
                    Component child = (Component) lexeme.getChild(k);
                    if (child instanceof Word) {
                        lexemes.add(child);
                    }
                }
            }
        }
        sortByFrequency(lexemes);

        Composite text = new Text();
        for (Component lexeme : lexemes) {
            text.add(lexeme);
        }
        logger.info("SortLexemesBySymbols' query() has been done");
        return text;
    }

    private int findSymbolFrequency(Component lexeme) {
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

    private void sortByFrequency(List<Component> lexemes) {
        Comparator<Component> comparatorFrequency = new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                int index = 0;
                index = findSymbolFrequency(o1) - findSymbolFrequency(o2);

                if (index == 0) {
                    String collectO1 = (String) o1.collect();
                    String collectO2 = (String) o2.collect();

                    index = collectO2.compareTo(collectO1);
                }
                return index;
            }
        };
        lexemes.sort(comparatorFrequency.reversed());
    }

    public static void main(String[] args) throws FileServiceException, HandlerException {
        TextStorageRepository storageRepository = RepositoryFactory.getInstance().getTextStorageRepository();
        String text = new FileInitialization("input.txt").initialize();
        TextParser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));
        Composite compositeText = new Text();
        parser.parse(compositeText, text);
        char symbol = 'i';
        Composite query = storageRepository.query(new SortLexemesBySymbols(symbol));
        String collect = query.collect();
        System.out.println(collect);
    }

}
