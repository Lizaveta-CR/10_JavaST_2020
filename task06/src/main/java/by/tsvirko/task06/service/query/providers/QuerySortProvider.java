package by.tsvirko.task06.service.query.providers;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.sort_query.*;
import by.tsvirko.task06.service.query.enums.QuerySortEnum;

import java.util.HashMap;
import java.util.Map;

public class QuerySortProvider {
    private final Map<QuerySortEnum, Query> repository = new HashMap<>();

    public QuerySortProvider() {

        repository.put(QuerySortEnum.TITLE, new SortTitleQuery());
        repository.put(QuerySortEnum.AUTHORS, new SortAuthorsQuery());
        repository.put(QuerySortEnum.NUMBEROFPAGES, new SortNumberOfPagesQuery());
        repository.put(QuerySortEnum.PUBLISHINGHOUSE, new SortPublishingHouseQuery());
        repository.put(QuerySortEnum.YEAROFPUBLISHING, new SortYearOfPublishingQuery());
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
