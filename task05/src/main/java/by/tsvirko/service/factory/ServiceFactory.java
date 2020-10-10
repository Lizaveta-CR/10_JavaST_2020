package main.java.by.tsvirko.service.factory;

import main.java.by.tsvirko.service.FileReading;
import main.java.by.tsvirko.service.StringService;
import main.java.by.tsvirko.service.impl.FileReadingImpl;
import main.java.by.tsvirko.service.impl.StringServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private StringService stringService = new StringServiceImpl();
    private FileReading fileReading = new FileReadingImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public StringService getStringService() {
        return stringService;
    }

    public FileReading getFileReading() {
        return fileReading;
    }
}
