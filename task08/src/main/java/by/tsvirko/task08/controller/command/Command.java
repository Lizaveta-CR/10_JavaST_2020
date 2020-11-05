package by.tsvirko.task08.controller.command;

import by.tsvirko.task08.entity.exception.ArrayException;
import by.tsvirko.task08.entity.exception.MatrixException;
import by.tsvirko.task08.service.exception.ServiceInitException;

import java.util.List;

public interface Command {
    String execute(List<String> request) throws MatrixException, ServiceInitException, ArrayException;
}
