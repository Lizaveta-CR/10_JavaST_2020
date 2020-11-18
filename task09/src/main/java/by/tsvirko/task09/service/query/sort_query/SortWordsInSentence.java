package by.tsvirko.task09.service.query.sort_query;

import by.tsvirko.task09.entity.TextStorage;
import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class SortWordsInSentence extends AbstractSortQuery {
    private static final Logger logger = LogManager.getLogger(SortWordsInSentence.class);

    @Override
    public Composite query(TextStorage textStorage) {
        Composite paragraph = (Composite) textStorage.getComponent(0);
        Comparator<Component> lengthComparator = new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                return Integer.compare(((Component) o1.getChild(0)).getSize()
                        , ((Component) o2.getChild(0)).getSize());
            }
        };
        Composite paragraphList = new Paragraph();
        int paragraphSize = paragraph.getSize();
        for (int i = 0; i < paragraphSize; i++) {
            Component sentence = (Component) paragraph.getChild(i);

            int sentenceSize = sentence.getSize();
            Composite sentenceList = new Sentence();
            for (int j = 0; j < sentenceSize; j++) {
                Component lexeme = (Component) sentence.getChild(j);
                List<Component> words = new ArrayList<>();
                int lexemeSize = lexeme.getSize();
                Map<Component, Component> map = new HashMap<>();
                for (int k = 0; k < lexemeSize; k++) {
                    Component child = (Component) lexeme.getChild(k);

                    if (child instanceof Word) {
                        words.add(child);
                    } else {
                        map.put((Component) lexeme.getChild(k - 1), child);
                    }
                }
                Collections.sort(words, lengthComparator);
                int sizeWords = words.size();
                Composite lexemeList = new Lexeme();
                for (int s = 0; s < sizeWords; s++) {
                    Component word = words.get(s);
                    if (map.containsKey(word)) {
                        lexemeList.add(word);
                        lexemeList.add(map.get(word));
                        map.remove(word);
                    } else {
                        lexemeList.add(word);
                    }
                }
                sentenceList.add(lexemeList);
            }
            paragraphList.add(sentenceList);
        }
        logger.info("SortWordsInSentence' query() has been done");
        return paragraphList;
    }
}
