package by.tsvirko.controller.command;

import by.tsvirko.entity.Flower;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Command interface
 */
public interface Command {
    Set<Flower> execute(String request);
}
