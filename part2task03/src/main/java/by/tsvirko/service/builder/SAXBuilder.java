package by.tsvirko.service.builder;

import by.tsvirko.service.parser.SAXParser;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {
    private static final Logger logger = LogManager.getLogger(SAXBuilder.class);

    private FlowerHandler handler;

    public SAXBuilder() {
        super();
        handler = new FlowerHandler();
        try {
            new SAXParser().parse(handler);
        } catch (ParserException | SAXException | IOException e) {
            logger.info("Parsing failed " + e.getMessage());
        }
    }

    @Override
    public void buildFlowers() {
        flowers = handler.getFlowers();
    }
}
