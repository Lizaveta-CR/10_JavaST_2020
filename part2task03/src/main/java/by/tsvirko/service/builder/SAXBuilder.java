package by.tsvirko.service.builder;

import by.tsvirko.service.builder.factory.ParserFactory;
import by.tsvirko.service.parser.SAXParser;
import by.tsvirko.service.parser.exception.ParserException;
import org.xml.sax.SAXException;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {
    private FlowerHandler handler;

    public SAXBuilder() {
        super();
        handler = new FlowerHandler();
        try {
            new SAXParser().parse(handler);
        } catch (ParserException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildFlowers() {
        flowers = handler.getFlowers();
    }
}
