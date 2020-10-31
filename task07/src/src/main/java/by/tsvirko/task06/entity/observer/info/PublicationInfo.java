package by.tsvirko.task06.entity.observer.info;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.entity.observer.Action;

public class PublicationInfo {
    private static PublicationInfo instance;
    private BookInfo bookInfo = BookInfo.getInstance();
    private MagazineInfo magazineInfo = MagazineInfo.getInstance();

    public void update(Publication publication, int year, Action action) {
        if (publication instanceof Book) {
            bookInfo.update(year, action);
        } else {
            magazineInfo.update(year, action);
        }
    }

    public static PublicationInfo getInstance() {
        return (instance == null) ? instance = new PublicationInfo() : instance;
    }
}
