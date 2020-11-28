package by.tsvirko.service.bulders.builderFlowers.factory;

import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.DOMBuilder;
import by.tsvirko.service.bulders.builderFlowers.SAXBuilder;
import by.tsvirko.service.bulders.builderFlowers.STAXBuilder;
import by.tsvirko.service.bulders.builderOrders.DOMBuilderOrders;

public class ParserFactory {
    private static final ParserFactory INSTANCE = new ParserFactory();

    private enum TypeParser {
        DOM_FLOWERS,
        SAX_FLOWERS,
        STAX_FLOWERS,
        DOM_ORDERS,
        SAX_ORDERS,
        STAX_ORDERS
    }

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public BaseBuilder createParser(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM_FLOWERS:
                return new DOMBuilder();
            case SAX_FLOWERS:
                return new SAXBuilder();
            case STAX_FLOWERS:
                return new STAXBuilder();
            case DOM_ORDERS:
                return new DOMBuilderOrders();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}
