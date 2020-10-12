package main.java.by.tsvirko.controller.command.impl;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.resource.ResourceManager;
import main.java.by.tsvirko.service.FileWorking;
import main.java.by.tsvirko.service.StringService;
import main.java.by.tsvirko.service.exception.FileOpeningException;
import main.java.by.tsvirko.service.factory.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class Task1 implements Command {
    private final int DATA_INDEX = 1;
    private final int TEXT_INDEX = 2;
    private final int INDEX = 3;
    private final int SYMBOL_INDEX = 4;

    private final String CONSOLE = "1";
    private final String FILE = "2";
    private final String RESULT_FILE = "Task1";

    @Override
    public String execute(List<String> request) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ResourceManager manager = ResourceManager.INSTANCE;
        StringService stringService = serviceFactory.getStringService();
        FileWorking fileReading = serviceFactory.getFileReading();
        String response = null;

        String text = request.get(TEXT_INDEX);
        String index = request.get(INDEX);
        String symbol = request.get(SYMBOL_INDEX);
        try {
            switch (request.get(DATA_INDEX)) {
                case CONSOLE:
                    response = stringService.changeEachSpecificLetterWithSymbol(text, index, symbol);
                    fileReading.write(RESULT_FILE, response);
                    break;
                case FILE:
                    String readText = fileReading.read(text);
                    response = stringService.changeEachSpecificLetterWithSymbol(readText, index, symbol);
                    fileReading.write(RESULT_FILE, response);
                    break;
            }
        } catch (IllegalArgumentException | FileOpeningException | IOException e) {
            System.err.println(e.getMessage());
            response = manager.getString("text.executeExceptionText");
        }
        return response;
    }
}
