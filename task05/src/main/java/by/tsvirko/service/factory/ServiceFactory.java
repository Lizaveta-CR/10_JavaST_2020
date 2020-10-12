package main.java.by.tsvirko.service.factory;

import main.java.by.tsvirko.service.BigFileReplaceService;
import main.java.by.tsvirko.service.FileWorking;
import main.java.by.tsvirko.service.StringService;
import main.java.by.tsvirko.service.impl.FileWorkingImpl;
import main.java.by.tsvirko.service.impl.StringServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private StringService stringService = new StringServiceImpl();
    private FileWorking fileReading = new FileWorkingImpl();
    private BigFileReplaceService bigFileReplaceService = new BigFileReplaceService();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public StringService getStringService() {
        return stringService;
    }

    public FileWorking getFileReading() {
        return fileReading;
    }

    public BigFileReplaceService getBigFileReplaceService() {
        return bigFileReplaceService;
    }
}
