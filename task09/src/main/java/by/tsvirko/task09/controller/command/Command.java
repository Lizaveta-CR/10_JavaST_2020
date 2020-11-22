package by.tsvirko.task09.controller.command;

import java.util.List;
import java.util.Optional;

public interface Command {
    Optional<String> execute(List<String> request);
}
