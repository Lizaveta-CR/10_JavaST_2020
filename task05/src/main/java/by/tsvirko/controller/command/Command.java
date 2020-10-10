package main.java.by.tsvirko.controller.command;

import java.util.List;

public interface Command {
    String execute(List<String> request);
}
