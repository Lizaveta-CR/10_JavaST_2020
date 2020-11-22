package by.tsvirko.task09.controller;

import by.tsvirko.task09.controller.command.Command;
import by.tsvirko.task09.controller.command.CommandName;
import by.tsvirko.task09.controller.command.impl.ParseCollectText;
import by.tsvirko.task09.controller.command.impl.SortLexemesBySymbolsCommand;
import by.tsvirko.task09.controller.command.impl.SortParagraphsBySentencesCommand;
import by.tsvirko.task09.controller.command.impl.SortWordsInSentenceCommand;
import by.tsvirko.task09.service.query.exception.RequestExceptionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class that provides different commands
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(CommandProvider.class);

    public CommandProvider() {
        repository.put(CommandName.PARAGRAPH_BY_SENTENCES, new SortParagraphsBySentencesCommand());
        repository.put(CommandName.PARSE_TEXT, new ParseCollectText());
        repository.put(CommandName.SORT_LEXEMES_SYMBOLS, new SortLexemesBySymbolsCommand());
        repository.put(CommandName.WORDS_IN_SENTENCE, new SortWordsInSentenceCommand());
    }

    public Command getCommand(String name) throws RequestExceptionService {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            logger.debug("Illegal command name occurred", e);
            throw new RequestExceptionService("Illegal command name", e);
        }
        return command;
    }
}
