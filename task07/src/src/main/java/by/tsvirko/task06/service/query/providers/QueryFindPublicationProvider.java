package by.tsvirko.task06.service.query.providers;

import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.service.query.Query;
import by.tsvirko.task06.service.query.book_query.find_query.*;
import by.tsvirko.task06.service.query.enums.QueryFindEnum;
import by.tsvirko.task06.service.query.enums.QueryFindPublicationEnum;
import by.tsvirko.task06.service.query.publication_query.find_query.FindByIdPublicationQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryFindPublicationProvider {
    private static final Logger logger = LogManager.getLogger(QueryFindPublicationProvider.class);

    private final Map<QueryFindPublicationEnum, Query> repository = new HashMap<>();

    public QueryFindPublicationProvider(List<String> findField) {
//        repository.put(QueryFindEnum.TITLE, new FindTitleQuery(findField.get(1)));
//        repository.put(QueryFindEnum.NUMBEROFPAGES, new FindNumberOfPagesQuery(findField.get(1)));
//        repository.put(QueryFindEnum.PUBLISHINGHOUSE, new FindPublishingHouseQuery(findField.get(1)));
        repository.put(QueryFindPublicationEnum.ID, new FindByIdPublicationQuery(findField.get(1)));
    }

    public Query getCommand(String name) throws RequestException {
        QueryFindPublicationEnum queryFindEnum;
        Query query;
        try {
            queryFindEnum = QueryFindPublicationEnum.valueOf(name.toUpperCase());
            query = repository.get(queryFindEnum);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug("Illegal command name", e.getMessage());
            throw new RequestException("Illegal command name", e);
        }
        return query;
    }
}
