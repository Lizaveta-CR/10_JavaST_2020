package by.tsvirko.service.bulders.builderOrders;

import by.tsvirko.entity.orders.Order;
import by.tsvirko.entity.orders.OrderEnum;
import by.tsvirko.entity.orders.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class OrderHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(OrderHandler.class);

    protected Set<Order> orders;
    private Order current = null;
    private Product currentProduct = null;
    private OrderEnum currentEnum = null;
    private EnumSet<OrderEnum> withText;
    private Set<Product> products;

    public OrderHandler() {
        withText = EnumSet.range(OrderEnum.ORDER, OrderEnum.ORDER_DATE);
        orders = new HashSet<>();
    }

    public Set<Order> getOrders() {
        return orders;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (OrderEnum.ORDER.getField().equals(localName)) {
            current = new Order();
            products = new HashSet<>();
            current.setId(attributes.getValue(OrderEnum.ORDER_ID.getField()));

            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd")
                        .parse((attributes.getValue(OrderEnum.ORDER_DATE.getField())));
            } catch (ParseException e) {
                logger.info("Date can not be parsed", e);
            }
            current.setDate(date);
        }
        if (OrderEnum.PERSON.getField().equals(localName)) {
            current.getPerson().setLogin(attributes.getValue(OrderEnum.LOGIN.getField()));
        } else {
            OrderEnum temp = OrderEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (OrderEnum.ORDER.getField().equals(localName)) {
            current.setProducts(products);
            orders.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String currentElem = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case EMAIL:
                    current.getPerson().setEmail(currentElem);
                    break;
                case TELEPHONE:
                    current.getPerson().setTelephone(Long.parseLong(currentElem));
                    break;
                case COUNTRY:
                    current.getPerson().getAddress().setCountry(currentElem);
                    break;
                case CITY:
                    current.getPerson().getAddress().setCity(currentElem);
                    break;
                case STREET:
                    current.getPerson().getAddress().setStreet(currentElem);
                    break;
                case APARTMENT_NUMBER:
                    current.getPerson().getAddress().setApartment_number(Integer.parseInt(currentElem));
                    break;
                case HOUSE_NUMBER:
                    current.getPerson().getAddress().setHouse_number(Integer.parseInt(currentElem));
                    break;
                case AMOUNT:
                    currentProduct = new Product();
                    currentProduct.setAmount(Integer.parseInt(currentElem));
                    break;
                case TYPE:
                    currentProduct.getProductItem().setType(currentElem);
                    break;
                case PRICE:
                    currentProduct.getProductItem().setPrice(new BigDecimal(currentElem));
                    break;
                case PRODUCER_NAME:
                    currentProduct.getProductItem().getProducer().setName(currentElem);
                    break;
                case PRODUCER_COUNTRY:
                    currentProduct.getProductItem().getProducer().setCountry(currentElem);
                    products.add(currentProduct);
                    break;
                default:
                    logger.info("No enum for parsing");
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
