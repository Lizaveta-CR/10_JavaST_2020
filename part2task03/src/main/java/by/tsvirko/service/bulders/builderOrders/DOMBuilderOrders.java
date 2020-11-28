package by.tsvirko.service.bulders.builderOrders;

import by.tsvirko.entity.orders.*;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.parser.DOMParser;
import by.tsvirko.service.parser.PathContainer;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DOMBuilderOrders extends BaseBuilder<Order> {
    private static final Logger logger = LogManager.getLogger(DOMBuilderOrders.class);
    private DOMParser domParser;

    public DOMBuilderOrders() {
        this.items = new HashSet<>();
        domParser = new DOMParser();
    }

    @Override
    public void build() {
        Document doc = null;
        try {
            doc = domParser.parse(PathContainer.ORDERS_XML, PathContainer.ORDERS_XSD);
            Element root = doc.getDocumentElement();

            NodeList nodeList = root.getElementsByTagName(OrderEnum.ORDER.getField());
            NodeList nodeListPerson = root.getElementsByTagName(OrderEnum.PERSON.getField());
            build(nodeList, nodeListPerson);
        } catch (
                ParserException e) {
            e.printStackTrace();
        }

    }

    private void build(NodeList nodeList, NodeList nodeListPerson) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element orderElement = (Element) nodeList.item(i);
            Element personElement = (Element) nodeListPerson.item(i);
            Person person = buildPerson(personElement);
            person.setAddress(buildAddress(orderElement));
            Order order = buildOrder(orderElement);
            order.setPerson(person);
            items.add(order);
        }
    }

    private Order buildOrder(Element orderElement) {
        Order order = new Order();
        order.setId(orderElement.getAttribute(OrderEnum.ORDER_ID.getField()));

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse((orderElement.getAttribute(OrderEnum.ORDER_DATE.getField())));
        } catch (ParseException e) {
            logger.info("Date can not be parsed", e);
        }
        order.setDate(date);

        order.setProducts(buildProduct(orderElement));
        return order;
    }

    private Person buildPerson(Element personElement) {
        Person person = new Person();

        person.setLogin(personElement.getAttribute(OrderEnum.LOGIN.getField()));
        person.setEmail(getElementTextContent(personElement, OrderEnum.EMAIL.getField()));
        person.setTelephone(Long.parseLong(getElementTextContent(personElement, OrderEnum.TELEPHONE.getField())));
        return person;
    }

    private Address buildAddress(Element element) {
        Address address = new Address();
        address.setCity(getElementTextContent(element, OrderEnum.CITY.getField()));
        address.setCountry(getElementTextContent(element, OrderEnum.COUNTRY.getField()));
        address.setStreet(getElementTextContent(element, OrderEnum.STREET.getField()));
        address.setApartment_number(Integer.parseInt(getElementTextContent(element, OrderEnum.APARTMENT_NUMBER.getField())));
        address.setHouse_number(Integer.parseInt(getElementTextContent(element, OrderEnum.HOUSE_NUMBER.getField())));
        return address;
    }

    private Set<Product> buildProduct(Element element) {
        NodeList products = element.getElementsByTagName(OrderEnum.PRODUCTS.getField());
        Set<Product> productSet = new HashSet<>();
        int productsLength = products.getLength();
        for (int i = 0; i < productsLength; i++) {
            Element item = (Element) products.item(i);

            Product product = new Product();
            product.setAmount(Integer.parseInt(getElementTextContent(item, OrderEnum.AMOUNT.getField())));

            ProductItem productItem = new ProductItem();

            productItem.setType(getElementTextContent(item, OrderEnum.TYPE.getField()));
            productItem.setPrice(new BigDecimal(getElementTextContent(item, OrderEnum.PRICE.getField())));

            productItem.setProducer(buildProducer(element));
            product.setProductItem(productItem);
            productSet.add(product);
        }
        return productSet;
    }

    private Producer buildProducer(Element element) {
        Producer producer = new Producer();
        producer.setCountry(getElementTextContent(element, OrderEnum.PRODUCER_COUNTRY.getField()));
        producer.setName(getElementTextContent(element, OrderEnum.PRODUCER_NAME.getField()));
        return producer;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
