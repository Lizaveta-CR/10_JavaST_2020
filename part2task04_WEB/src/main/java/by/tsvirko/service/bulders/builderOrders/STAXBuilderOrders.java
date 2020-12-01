package by.tsvirko.service.bulders.builderOrders;

import by.tsvirko.entity.flowers.*;
import by.tsvirko.entity.orders.*;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.parser.PathContainer;
import by.tsvirko.service.parser.STAXParser;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class STAXBuilderOrders extends BaseBuilder<Order> {
    private static final Logger logger = LogManager.getLogger(STAXBuilderOrders.class);

    private XMLStreamReader reader;


    public STAXBuilderOrders() {
        super();
        try {
            reader = new STAXParser().parse(PathContainer.ORDERS_XML, PathContainer.ORDERS_XSD);
        } catch (ParserException | IOException | SAXException e) {
            logger.error("STAXBuilder parsing failed!", e.getMessage());
        }
    }

    @Override
    public void build() {
        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(OrderEnum.ORDER.getField())) {
                        Order order = buildOrder(reader, new Order());
                        items.add(order);
                    }
                }
            }
        } catch (XMLStreamException | ParseException e) {
            logger.debug("StAX parsing error! ", e);
        }
    }

    private Order buildOrder(XMLStreamReader reader, Order order) throws XMLStreamException, ParseException {
        order.setId(reader.getAttributeValue(null, OrderEnum.ORDER_ID.getField()));

        Date date = null;

        if ((reader.getAttributeValue(null, OrderEnum.ORDER_DATE.getField()) != null)) {
            try {
                String attributeValue = reader.getAttributeValue(null, OrderEnum.ORDER_DATE.getField());
                date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse((attributeValue));
            } catch (ParseException e) {
                logger.info("Date can not be parsed", e);
            }
            order.setDate(date);
        } else {
            Calendar calendar = new GregorianCalendar(2020, 8, 27);
            order.setDate(calendar.getTime());
        }


        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case PERSON:
                            order.setPerson(getXMLPerson(reader));
                            break;
                        case PRODUCTS:
                            order.setProduct(getXMLProduct(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName().toUpperCase();
                    OrderEnum orderEnum = OrderEnum.valueOf(name);
                    if (orderEnum == OrderEnum.ORDER) {
                        return order;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element");
    }

    private Person getXMLPerson(XMLStreamReader reader) throws XMLStreamException {
        Person person = new Person();
        person.setLogin(reader.getAttributeValue(null, OrderEnum.LOGIN.getField()));
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case EMAIL:
                            person.setEmail(getXMLText(reader));
                            break;
                        case TELEPHONE:
                            person.setTelephone(Long.parseLong(getXMLText(reader)));
                            break;
                        case COUNTRY:
                            person.getAddress().setCountry(getXMLText(reader));
                            break;
                        case CITY:
                            person.getAddress().setCity(getXMLText(reader));
                            break;
                        case STREET:
                            person.getAddress().setStreet(getXMLText(reader));
                            break;
                        case APARTMENT_NUMBER:
                            person.getAddress().setApartment_number(Integer.parseInt(getXMLText(reader)));
                            break;
                        case HOUSE_NUMBER:
                            person.getAddress().setHouse_number(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.PERSON) {
                        return person;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag growing-tips");
    }

    private Product getXMLProduct(XMLStreamReader reader) throws XMLStreamException {
        Product product = new Product();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case AMOUNT:
                            product.setAmount(Integer.parseInt(getXMLText(reader)));
                            break;
                        case TYPE:
                            product.getProductItem().setType(getXMLText(reader));
                            break;
                        case PRICE:
                            product.getProductItem().setPrice(new BigDecimal(getXMLText(reader)));
                            break;
                        case PRODUCER:
                            product.getProductItem().setProducer(getXMLProducer(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.PRODUCTS) {
                        return product;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag growing-tips");
    }

    private Producer getXMLProducer(XMLStreamReader reader) throws XMLStreamException {
        Producer producer = new Producer();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case PRODUCER_NAME:
                            producer.setName(getXMLText(reader));
                            break;
                        case PRODUCER_COUNTRY:
                            producer.setCountry(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.PRODUCER) {
                        return producer;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag growing-tips");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
