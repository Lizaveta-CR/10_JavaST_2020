package part2task04.service.builder.builderOrders;

import by.tsvirko.entity.orders.OrderEnum;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderOrders.DOMBuilderOrders;
import by.tsvirko.service.bulders.builderOrders.SAXBuilderOrders;
import by.tsvirko.service.parser.DOMParser;
import by.tsvirko.service.parser.PathContainer;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;


public class SAXBuilderOrdersTest {
    private BaseBuilder builder = new SAXBuilderOrders();

    @Test(description = "Testing SAXBuilder' buildOrders() method")
    public void testBuildSize() {
        builder.build();
        int size = builder.getItems().size();
        try {

            Document doc = new DOMParser().parse(PathContainer.ORDERS_XML, PathContainer.ORDERS_XSD);

            int actualLength = doc.getElementsByTagName(OrderEnum.ORDER.getField()).getLength();

            Assert.assertEquals(size, actualLength);
        } catch (Exception e) {
        }
    }
}
