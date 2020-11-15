package by.tsvirko.task09.service.query.sort_query;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.*;

import java.util.*;

public class SortParagraphsBySentences extends AbstractSortQuery {

    public SortParagraphsBySentences(boolean descending) {
        super(descending);
    }

    public SortParagraphsBySentences() {
    }

    @Override
    public Composite query(Composite text) {
        Composite paragraph = (Composite) text.getChild(0);
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

        return paragraph;
    }

    private Map<Component, Integer> sortByValuesAsc(Map<Component, Integer> map) {
        Map<Component, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Component, Integer>comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    private Map<Component, Integer> sortByValuesDesc(Map<Component, Integer> map) {
        Map<Component, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<Component, Integer>comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }
}
