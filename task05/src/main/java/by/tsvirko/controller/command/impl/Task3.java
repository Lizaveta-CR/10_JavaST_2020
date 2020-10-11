package main.java.by.tsvirko.controller.command.impl;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.resource.ResourceManager;
import main.java.by.tsvirko.service.FileReading;
import main.java.by.tsvirko.service.StringService;
import main.java.by.tsvirko.service.exception.FileOpeningException;
import main.java.by.tsvirko.service.factory.ServiceFactory;

import java.util.List;

public class Task3 implements Command {
    private final int DATA_INDEX = 1;
    private final int TEXT_INDEX = 2;
    private final int LENGTH_INDEX = 3;
    private final int SUBSTRING_INDEX = 4;

    private final String CONSOLE = "1";
    private final String FILE = "2";

    @Override
    public String execute(List<String> request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ResourceManager manager = ResourceManager.INSTANCE;
        StringService stringService = serviceFactory.getStringService();
        FileReading fileReading = serviceFactory.getFileReading();
        String response = null;

        String text = request.get(TEXT_INDEX);
        String length = request.get(LENGTH_INDEX);
        String substring = request.get(SUBSTRING_INDEX);
        try {
            switch (request.get(DATA_INDEX)) {
                case CONSOLE:
                    response = stringService.replaceWithSubstring(text, substring, Integer.parseInt(length));
                    break;
                case FILE:
                    String readText = fileReading.read(text);
                    response = stringService.replaceWithSubstring(readText, substring, Integer.parseInt(length));
                    break;
            }
        } catch (FileOpeningException | NumberFormatException e) {
            System.err.println(e.getMessage());
            response = manager.getString("text.executeExceptionText");
        }
        return response;
    }
}
