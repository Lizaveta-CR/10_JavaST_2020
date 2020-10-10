package main.java.by.tsvirko.controller;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.controller.exception.RequestException;

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
            response = executionCommand.execute(request);
        } catch (RequestException e) {
            response = "No enum constant";
            System.err.println(e.getCause());
        }
        return response;
    }
}
