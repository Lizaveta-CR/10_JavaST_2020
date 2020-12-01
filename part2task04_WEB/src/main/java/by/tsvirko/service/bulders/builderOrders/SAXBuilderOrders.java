package by.tsvirko.service.bulders.builderOrders;

import by.tsvirko.entity.orders.Order;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.parser.PathContainer;
import by.tsvirko.service.parser.SAXParser;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import java.io.IOException;

public class SAXBuilderOrders extends BaseBuilder<Order> {
    private static final Logger logger = LogManager.getLogger(SAXBuilderOrders.class);

    private OrderHandler handler;

    public SAXBuilderOrders() {
        super();
        handler = new OrderHandler();
        try {
            new SAXParser().parse(PathContainer.ORDERS_XML, PathContainer.ORDERS_XSD, handler);
        } catch (ParserException | SAXException | IOException e) {
            logger.info("Parsing failed " + e.getMessage());
        }
    }

    @Override
    public void build() {
        items = handler.getOrders();
    }
}
