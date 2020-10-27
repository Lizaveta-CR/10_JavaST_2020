package by.tsvirko.task06.service.factory;

import by.tsvirko.task06.service.PublicationService;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.impl.LibrarianService;
import by.tsvirko.task06.service.impl.PublicationServiceImpl;
import by.tsvirko.task06.service.impl.book.FileBookServicempl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private PublicationService publicationService = new PublicationServiceImpl();
    private FileBookService fileBookService = new FileBookServicempl();
    private LibrarianService observerAddingService = new LibrarianService();

    public static ServiceFactory getInstance() {
        return instance;
    }


    public FileBookService getFileBookService() {
        return fileBookService;
    }

    public PublicationService getPublicationService() {
        return publicationService;
    }

    public LibrarianService getObserverAddingService() {
        return observerAddingService;
    }
}
