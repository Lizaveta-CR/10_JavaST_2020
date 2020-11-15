package by.tsvirko.task09.service.query.providers;

import by.tsvirko.task09.service.query.Query;
import by.tsvirko.task09.service.query.SortQueryEnum;
import by.tsvirko.task09.service.query.exception.RequestException;
import by.tsvirko.task09.service.query.sort_query.SortParagraphsBySentences;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuerySortProvider {
    private static final Logger logger = LogManager.getLogger(QuerySortProvider.class);

    private final Map<SortQueryEnum, Query> repository = new HashMap<>();

    public QuerySortProvider() {
        repository.put(SortQueryEnum.PARAGRAPH_BY_SENTENCES, new SortParagraphsBySentences());
    }

    public Query getCommand(String name) throws RequestException {
        SortQueryEnum querySortEnum;
        Query query;
        try {
            querySortEnum = SortQueryEnum.valueOf(name.toUpperCase());
            query = repository.get(querySortEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug("Illegal command name", e.getMessage());
            throw new RequestException("Illegal command name", e);
        }
        return query;
    }
}
