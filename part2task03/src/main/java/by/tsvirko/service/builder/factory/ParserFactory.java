package by.tsvirko.service.builder.factory;

import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.DOMBuilder;

public class ParserFactory {
    private static final ParserFactory INSTANCE = new ParserFactory();

    private enum TypeParser {
        DOM
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
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
