package by.tsvirko.task09.service.factory;

import by.tsvirko.task09.service.FileInitialization;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private FileInitialization fileInitialization = new FileInitialization();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public FileInitialization getFileInitialization() {
        return fileInitialization;
    }
}
