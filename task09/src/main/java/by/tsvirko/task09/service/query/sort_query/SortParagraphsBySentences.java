package by.tsvirko.task09.service.query.sort_query;

import by.tsvirko.task09.entity.TextStorage;
import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.query.QuerySortServiceController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Sorts paragraphs by sentences
 */
public class SortParagraphsBySentences extends AbstractSortQuery {
    private static final Logger logger = LogManager.getLogger(SortParagraphsBySentences.class);

    public SortParagraphsBySentences(boolean descending) {
        super(descending);
    }

    public SortParagraphsBySentences() {
    }

    @Override
    public Composite query(TextStorage text) {
        Composite paragraph = (Composite) text.getComponent(0);
        Map<Component, Integer> map = new HashMap<>();

        int paragraphSize = paragraph.getSize();
        for (int i = 0; i < paragraphSize; i++) {
            Component sentence = (Component) paragraph.getChild(i);

            int sentenceSize = sentence.getSize();
            map.put(sentence, sentenceSize);
        }
        for (Map.Entry<Component, Integer> entry : map.entrySet()) {
            paragraph.remove(entry.getKey());
        }

        Map<Component, Integer> sortedMap = null;

        if (isDescending()) {
            sortedMap = sortByValuesDesc(map);
        } else {
            sortedMap = sortByValuesAsc(map);
        }

        for (Map.Entry<Component, Integer> entry : sortedMap.entrySet()) {
            paragraph.add(entry.getKey());
        }
        logger.info("SortParagraphsBySentences' query() has been done");
        return paragraph;
    }

    /**
     * Sorts map by values in ascending order
     *
     * @param map
     * @return Map<Component, Integer> - new map,where Integer represents frequency
     */
    private Map<Component, Integer> sortByValuesAsc(Map<Component, Integer> map) {
        Map<Component, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Component, Integer>comparingByValue()
                        .thenComparing(componentIntegerEntry ->
                                ((Composite) componentIntegerEntry.getKey().getChild(0)).getSize()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    /**
     * Sorts map by values in descending order
     *
     * @param map
     * @return Map<Component, Integer> - new map,where Integer represents frequency
     */
    private Map<Component, Integer> sortByValuesDesc(Map<Component, Integer> map) {
        Map<Component, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Component, Integer>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(componentIntegerEntry ->
                                ((Composite) componentIntegerEntry.getKey().getChild(0)).getSize()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
}
