package by.tsvirko.service.builder;

import by.tsvirko.service.builder.factory.ParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {
    private FlowerHandler handler;
    private XMLReader reader;

    public SAXBuilder() {
        super();
        handler = new FlowerHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
//            LOGGER.error("Sax Constructor exception", e);
            System.err.println(e);
        }
    }

    @Override
    public void buildFlowers() {
        try {
            reader.parse(new InputSource("/Users/elizaveta/Downloads/10_JavaST_2020/part2task03/src/main/resources/data/flowers.xml"));
            flowers = handler.getFlowers();
        } catch (SAXException | IOException e) {
            System.err.println(e);
//            LOGGER.error("SAX parsing error! ", e);
        }
    }

    public static void main(String[] args) {
        BaseBuilder flowerParser = ParserFactory.getInstance().createFlowerParser("SAX");
        flowerParser.buildFlowers();
        flowerParser.getFlowers().forEach(System.out::println);
    }
}
