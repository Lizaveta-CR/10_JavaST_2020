package by.tsvirko.service.builder.factory;

import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.DOMBuilder;
import by.tsvirko.service.builder.SAXBuilder;

public class ParserFactory {
    private static final ParserFactory INSTANCE = new ParserFactory();

    private enum TypeParser {
        DOM,
        SAX
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
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
