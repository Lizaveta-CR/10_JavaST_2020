package by.tsvirko.task09.service.query.factory;

import by.tsvirko.task09.service.query.QuerySortServiceController;

public class SortFactory {
    private static final SortFactory instance = new SortFactory();

    private QuerySortServiceController sortServiceController = new QuerySortServiceController();

    public static SortFactory getInstance() {
        return instance;
    }

    public QuerySortServiceController getSortServiceController() {
        return sortServiceController;
    }
}
