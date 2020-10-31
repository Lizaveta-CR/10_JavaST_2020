package by.tsvirko.task06.entity.observer.info;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.observer.Action;

/**
 * Deligates Info between classes
 */
public class PublicationInfo {
    private static PublicationInfo instance;
    private BookInfo bookInfo = BookInfo.getInstance();
    private MagazineInfo magazineInfo = MagazineInfo.getInstance();

    /**
     * Updates publication in observer
     *
     * @param publication
     * @param year
     * @param action
     */
    public void update(Publication publication, int year, Action action) {
        if (publication instanceof Book) {
            bookInfo.update(year, action);
        } else {
            magazineInfo.update(year, action);
        }
    }

    /**
     * Returns  PublicationInfo instance
     *
     * @return
     */
    public static PublicationInfo getInstance() {
        return (instance == null) ? instance = new PublicationInfo() : instance;
    }
}
