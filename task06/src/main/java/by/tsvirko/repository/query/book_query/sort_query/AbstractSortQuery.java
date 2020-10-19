package by.tsvirko.repository.query.book_query.sort_query;


import by.tsvirko.entity.Book;
import by.tsvirko.entity.BookStorage;
import by.tsvirko.repository.query.Query;

public abstract class AbstractSortQuery implements Query<Book, BookStorage> {
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
        this.descending = isDescending();
    }

    public boolean isDescending() {
        return descending;
    }
}
