package by.tsvirko.task09.service.query.sort_query;


import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.query.Query;

public abstract class AbstractSortQuery implements Query<Composite> {
    /**
     * Determines whether sorting occurs in descending or ascending order
     */
    private final boolean descending;

    /**
     * Default constructor with ascending order for sorting
     */
    public AbstractSortQuery() {
        this.descending = false;
    }

    /**
     * Constructor for creating settings for sorting
     *
     * @param descending
     */
    public AbstractSortQuery(final boolean descending) {
        this.descending = descending;
    }

    public boolean isDescending() {
        return descending;
    }
}
