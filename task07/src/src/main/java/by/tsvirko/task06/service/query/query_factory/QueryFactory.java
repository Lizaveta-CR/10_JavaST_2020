package by.tsvirko.task06.service.query.query_factory;

import by.tsvirko.task06.service.query.QueryFindPublicationServiceController;
import by.tsvirko.task06.service.query.QueryFindServiceController;
import by.tsvirko.task06.service.query.QuerySortServiceController;

public class QueryFactory {
    private static final QueryFactory factory = new QueryFactory();

    private QuerySortServiceController querySortServiceController = new QuerySortServiceController();
    private QueryFindServiceController queryFindServiceController = new QueryFindServiceController();
    private QueryFindPublicationServiceController queryFindPublicationServiceController = new QueryFindPublicationServiceController();

    public static QueryFactory getFactory() {
        return factory;
    }

    public QuerySortServiceController getQuerySortServiceController() {
        return querySortServiceController;
    }

    public QueryFindServiceController getQueryFindServiceController() {
        return queryFindServiceController;
    }

    public QueryFindPublicationServiceController getQueryFindPublicationServiceController() {
        return queryFindPublicationServiceController;
    }
}
