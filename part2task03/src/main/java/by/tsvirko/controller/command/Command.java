package by.tsvirko.controller.command;

import by.tsvirko.entity.flowers.Flower;

import java.util.Set;

/**
 * Command interface
 */
public interface Command {
    Set<Flower> execute(String request);
}
