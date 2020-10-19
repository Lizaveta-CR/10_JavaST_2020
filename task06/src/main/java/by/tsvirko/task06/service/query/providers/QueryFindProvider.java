package by.tsvirko.task06.service.query.providers;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.FindAuthorsQuery;
import by.tsvirko.task06.service.query.book_query.find_query.FindTitleQuery;
import by.tsvirko.task06.service.query.enums.QueryFindEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryFindProvider {

    private final Map<QueryFindEnum, Query> repository = new HashMap<>();

    public QueryFindProvider(List<String> findField) {
        repository.put(QueryFindEnum.TITLE, new FindTitleQuery(findField.get(0)));
        repository.put(QueryFindEnum.AUTHORS, new FindAuthorsQuery(findField.get(1)));
    }

    public Query getCommand(String name) throws RequestException {
        QueryFindEnum queryFindEnum;
        Query query;
        try {
            queryFindEnum = QueryFindEnum.valueOf(name.toUpperCase());
            query = repository.get(queryFindEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new RequestException("Illegal command name", e);
        }
        return query;
    }
}
