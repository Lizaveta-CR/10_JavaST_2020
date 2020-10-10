package main.java.by.tsvirko.controller;

import main.java.by.tsvirko.controller.command.Command;
import main.java.by.tsvirko.controller.exception.RequestException;


public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public String executeTask(String request) {
        String commandName;
        Command executionCommand;
        String response = null;

        try {
            commandName = request;
            executionCommand = provider.getCommand(commandName);
            response = executionCommand.execute(request);
        } catch (RequestException e) {
            System.err.println(e.getCause());
        }
        return response;
    }
}
