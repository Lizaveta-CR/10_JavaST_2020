package by.tsvirko.task09.controller.command.impl;

import by.tsvirko.task09.controller.command.Command;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Text;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import by.tsvirko.task09.service.chainOfResponsibility.factory.ParserFactory;
import by.tsvirko.task09.service.factory.ServiceFactory;
import by.tsvirko.task09.service.query.exception.FileServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

/*
Command to parse and collect text
 */
public class ParseCollectText implements Command {
    private static final Logger logger = LogManager.getLogger(ParseCollectText.class);

    @Override
    public Optional<String> execute(List<String> request) {
        ParserFactory instance = ParserFactory.getFactory();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Optional<String> response = null;
        try {
            FileInitialization fileInitialization = serviceFactory.getFileInitialization();
            fileInitialization.setFilename(request.get(1));
            Composite parse = instance.getParser().parse(new Text(), fileInitialization.initialize());
            response = Optional.ofNullable(parse.collect());
            logger.info("Text has been parsed and collected");
        } catch (FileServiceException | HandlerException e) {
            logger.error(e.getMessage());
        }
        return response;
    }
}
