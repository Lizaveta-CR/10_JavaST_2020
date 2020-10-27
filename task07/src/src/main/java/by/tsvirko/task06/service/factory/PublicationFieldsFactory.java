package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.PublicationFieldsCreator;
import by.tsvirko.task06.service.impl.book.BookFieldsCreator;
import by.tsvirko.task06.service.impl.magazine.MagazineFieldsCreator;

public abstract class PublicationFieldsFactory {
    public static PublicationFieldsCreator getFields(PublicationType publicationType) {
        PublicationFieldsCreator publication = null;

        switch (publicationType) {
            case BOOK:
                publication = new BookFieldsCreator();
                break;
            case MAGAZINE:
                publication = new MagazineFieldsCreator();
                break;
            default:
                throw new EnumConstantNotPresentException(PublicationType.class, publicationType.name());
        }
        return publication;
    }
}
