package by.tsvirko.task06.service.query.query_factory;

import by.tsvirko.task06.service.query.QueryFindPublicationServiceController;
import by.tsvirko.task06.service.query.QuerySortPublicationServiceController;

public class QueryFactory {
    private static final QueryFactory factory = new QueryFactory();

    //    private QuerySortServiceController querySortServiceController = new QuerySortServiceController();
//    private QueryFindServiceController queryFindServiceController = new QueryFindServiceController();
    private QueryFindPublicationServiceController queryFindPublicationServiceController = new QueryFindPublicationServiceController();
    private QuerySortPublicationServiceController querySortPublicationServiceController = new QuerySortPublicationServiceController();

    public static QueryFactory getFactory() {
        return factory;
    }

    public QueryFindPublicationServiceController getQueryFindPublicationServiceController() {
        return queryFindPublicationServiceController;
    }

    public QuerySortPublicationServiceController getQuerySortPublicationServiceController() {
        return querySortPublicationServiceController;
    }
}
