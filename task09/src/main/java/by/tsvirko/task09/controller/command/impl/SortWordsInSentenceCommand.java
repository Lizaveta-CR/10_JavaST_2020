package by.tsvirko.task09.controller.command.impl;

import by.tsvirko.task09.controller.command.Command;
import by.tsvirko.task09.service.exception.ServiceException;
import by.tsvirko.task09.service.query.SortQueryEnum;
import by.tsvirko.task09.service.query.factory.SortFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Command to sort words in sentence
 */
public class SortWordsInSentenceCommand implements Command {
    private static final Logger logger = LogManager.getLogger(SortLexemesBySymbolsCommand.class);

    @Override
    public Optional<String> execute(List<String> request) {
        SortFactory instance = SortFactory.getInstance();
        Optional<String> response = null;
        List<String> strings = new ArrayList<>();
        strings.add(SortQueryEnum.WORDS_IN_SENTENCE.name());
        strings.add(request.get(0));
        try {
            instance.getSortServiceController().sort(strings);
            response = Optional.of("Sorting has been done");
        } catch (ServiceException e) {
            logger.debug(e.getMessage());
        }
        return response;
    }
}
