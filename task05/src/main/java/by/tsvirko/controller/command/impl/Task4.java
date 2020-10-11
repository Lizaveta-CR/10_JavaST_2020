package main.java.by.tsvirko.controller.command.impl;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.resource.ResourceManager;
import main.java.by.tsvirko.service.BigFileReplaceService;
import main.java.by.tsvirko.service.factory.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class Task4 implements Command {
    private final int DATA_INDEX = 1;
    private final int TEXT_INDEX = 2;

    private final String CONSOLE = "1";
    private final String FILE = "2";

    @Override
    public String execute(List<String> request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        BigFileReplaceService replaceService = serviceFactory.getBigFileReplaceService();
        ResourceManager manager = ResourceManager.INSTANCE;
        String response = null;

        String text = request.get(TEXT_INDEX);
        try {
            switch (request.get(DATA_INDEX)) {
                case CONSOLE:
                    response = replaceService.removeNonAlphanumeric(text);
                    break;
                case FILE:
                    replaceService.removeNonAlphanumericFile(text);
                    return response = manager.getString("text.checkFile");
            }
        } catch (NumberFormatException | IOException e) {
            System.err.println(e.getMessage());
            response = manager.getString("text.executeExceptionText");
        }
        return response;
    }
}
