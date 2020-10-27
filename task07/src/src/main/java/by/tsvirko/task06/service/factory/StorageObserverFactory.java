package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.StorageObserverCreator;
import by.tsvirko.task06.service.impl.LibrarianService;

/**
 * Class to delegate creating observers
 */
public class StorageObserverFactory {
    public static StorageObserverCreator getObserver(ObserverType observerType) {
        StorageObserverCreator observer = null;

        switch (observerType) {
            case LIBRARIAN:
                observer = new LibrarianService();
                break;
            default:
                throw new EnumConstantNotPresentException(ObserverType.class, observerType.name());
        }
        return observer;
    }
}
