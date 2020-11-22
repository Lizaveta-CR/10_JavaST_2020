package by.tsvirko.task09.controller.command;

import java.util.List;
import java.util.Optional;

/**
 * Command interface
 */
public interface Command {
    Optional<String> execute(List<String> request);
}
