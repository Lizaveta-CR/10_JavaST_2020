package by.tsvirko.task06.service.impl.book;

import by.tsvirko.task06.entity.Book;
import by.tsvirko.task06.entity.Publication;
import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.exception.ServiceInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BookCreator extends PublicationCreator {
    private static final Logger logger = LogManager.getLogger(BookCreator.class);

    /**
     * Creates new book
     *
     * @param bookFieldsUser
     * @return
     * @throws ServiceInitException
     */
    @Override
    public Publication create(List<String> bookFieldsUser) throws ServiceInitException {
        Publication publication = new Book();
        Book book = (Book) publication;
        try {
            book.setTitle(bookFieldsUser.get(0));
            book.setNumberOfPages(Integer.valueOf(bookFieldsUser.get(1)));
            book.setPublishingHouse(bookFieldsUser.get(2));
            book.setAuthor(bookFieldsUser.get(3));
            book.setYearOfPublishing(Integer.valueOf(bookFieldsUser.get(4)));
        } catch (NumberFormatException e) {
            logger.debug("Create book error", e.getMessage());
            throw new ServiceInitException("Invalid parametres");
        }
        return book;
    }
}
