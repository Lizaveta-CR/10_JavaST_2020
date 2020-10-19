package by.tsvirko.task06.controller;

import by.tsvirko.task06.controller.command.Command;
import by.tsvirko.task06.controller.exception.RequestException;
import by.tsvirko.task06.dao.exception.BookStorageElementException;

import java.util.List;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(List<String> request) {
        String commandName;
        Command executionCommand;
        String response = null;

        try {
            commandName = request.get(0);
            executionCommand = provider.getCommand(commandName);
            request.remove(0);
            response = executionCommand.execute(request);
        } catch (RequestException | BookStorageElementException e) {
            response = "No enum constant";
            System.err.println(e.getCause());
        }
        return response;
    }
}
