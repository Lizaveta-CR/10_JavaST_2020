package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.PublicationService;
import by.tsvirko.task06.service.WritingService;
import by.tsvirko.task06.service.impl.LibrarianService;
import by.tsvirko.task06.service.impl.PublicationServiceImpl;
import by.tsvirko.task06.service.impl.WritingServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private PublicationService publicationService = new PublicationServiceImpl();
    private WritingService writingService = new WritingServiceImpl();
    private LibrarianService observerAddingService = new LibrarianService();

    public static ServiceFactory getInstance() {
        return instance;
    }


    public WritingService getWritingService() {
        return writingService;
    }

    public PublicationService getPublicationService() {
        return publicationService;
    }

    public LibrarianService getObserverAddingService() {
        return observerAddingService;
    }
}
