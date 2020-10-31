package by.tsvirko.task06.service.query.providers;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.enums.QuerySortPublicationEnum;
import by.tsvirko.task06.service.query.publication_query.sort_query.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuerySortPublicationProvider {
    private static final Logger logger = LogManager.getLogger(QuerySortPublicationProvider.class);

    private final Map<QuerySortPublicationEnum, Query> repository = new HashMap<>();

    public QuerySortPublicationProvider() {
        repository.put(QuerySortPublicationEnum.TITLE, new SortTitleQuery());
        repository.put(QuerySortPublicationEnum.ID, new SortIdQuery());
        repository.put(QuerySortPublicationEnum.TITLENUMBEROFPAGES, new SortTitleNumOfPagesQuery());
        repository.put(QuerySortPublicationEnum.NUMBEROFPAGES, new SortNumOfPagesQuery());
        repository.put(QuerySortPublicationEnum.PUBLISHINGHOUSE, new SortPublHouseQuery());
    }

    /**
     * Gets command from repository
     *
     * @param name
     * @return Query - command
     * @throws RequestException
     */
    public Query getCommand(String name) throws RequestException {
        QuerySortPublicationEnum querySortEnum;
        Query query;
        try {
            querySortEnum = QuerySortPublicationEnum.valueOf(name.toUpperCase());
            query = repository.get(querySortEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug("Illegal command name", e.getMessage());
            throw new RequestException("Illegal command name", e);
        }
        return query;
    }
}
