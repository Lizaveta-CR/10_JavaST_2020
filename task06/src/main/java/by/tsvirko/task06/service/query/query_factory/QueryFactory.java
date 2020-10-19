package by.tsvirko.task06.service.query.query_factory;

import by.tsvirko.task06.service.query.QuerySortServiceController;

public class QueryFactory {
    private static final QueryFactory factory = new QueryFactory();

    private QuerySortServiceController querySortServiceController = new QuerySortServiceController();

    public static QueryFactory getFactory() {
        return factory;
    }

    public QuerySortServiceController getQuerySortServiceController() {
        return querySortServiceController;
    }
}
