package by.tsvirko.task06.service.query;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.service.query.book_query.sort_query.SortTitleQuery;

import java.util.HashMap;
import java.util.Map;

public class QuerySortProvider {
    private final Map<QuerySortEnum, Query> repository = new HashMap<>();

    public QuerySortProvider() {
        repository.put(QuerySortEnum.TITLE, new SortTitleQuery());
    }

    public Query getCommand(String name) throws RequestException {
        QuerySortEnum querySortEnum;
        Query query;
        try {
            querySortEnum = QuerySortEnum.valueOf(name.toUpperCase());
            query = repository.get(querySortEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RequestException("Illegal command name", e);
        }
        return query;
    }
}
