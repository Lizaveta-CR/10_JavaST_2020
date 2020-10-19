package by.tsvirko.task06.controller.command;

import by.tsvirko.task06.dao.exception.BookStorageElementException;

import java.util.List;

public interface Command {
    String execute(List<String> request) throws BookStorageElementException;
}
