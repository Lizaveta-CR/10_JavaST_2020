package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.PublicationCreator;
import by.tsvirko.task06.service.impl.book.BookCreator;
import by.tsvirko.task06.service.impl.magazine.MagazineCreator;

public abstract class PublicationFactory {
    public static PublicationCreator getPublication(PublicationType publicationType) {
        PublicationCreator publication = null;

        switch (publicationType) {
            case BOOK:
                publication = new BookCreator();
                break;
            case MAGAZINE:
                publication = new MagazineCreator();
                break;
            default:
                throw new EnumConstantNotPresentException(PublicationType.class, publicationType.name());
        }
        return publication;
    }
}
