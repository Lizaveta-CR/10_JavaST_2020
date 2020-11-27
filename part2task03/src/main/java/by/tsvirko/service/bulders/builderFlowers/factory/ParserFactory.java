package by.tsvirko.service.bulders.builderFlowers.factory;

import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.DOMBuilder;
import by.tsvirko.service.bulders.builderFlowers.SAXBuilder;
import by.tsvirko.service.bulders.builderFlowers.STAXBuilder;

public class ParserFactory {
    private static final ParserFactory INSTANCE = new ParserFactory();

    private enum TypeParser {
        DOM,
        SAX,
        STAX
    }

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public BaseBuilder createFlowerParser(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMBuilder();
            case SAX:
                return new SAXBuilder();
            case STAX:
                return new STAXBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
