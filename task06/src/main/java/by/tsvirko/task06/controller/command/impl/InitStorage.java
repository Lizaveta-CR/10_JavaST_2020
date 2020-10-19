package by.tsvirko.task06.controller.command.impl;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.dao.exception.BookStorageElementException;
import by.tsvirko.task06.service.FileBookService;
import by.tsvirko.task06.service.factory.ServiceFactory;

import java.io.IOException;
import java.util.List;

public class InitStorage implements Command {
    @Override
    public String execute(List<String> request) {
        ServiceFactory instance = ServiceFactory.getInstance();
        FileBookService fileBookService = instance.getFileBookService();
        String response = null;
        try {
            fileBookService.writeRandom();
            response = "Info has been written";
        } catch (IOException | BookStorageElementException | ClassNotFoundException e) {
            System.err.println(e.getCause());
            response = "Error";
        }
        return response;
    }
}
