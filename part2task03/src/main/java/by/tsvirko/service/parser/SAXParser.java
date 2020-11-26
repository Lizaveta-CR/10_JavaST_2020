package by.tsvirko.service.parser;

import by.tsvirko.entity.flowers.Flower;
import by.tsvirko.service.builder.FlowerHandler;
import by.tsvirko.service.parser.exception.ParserException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class SAXParser {
    private XMLReader reader;

    public XMLReader parse(DefaultHandler handler) throws ParserException, IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        SchemaFactory schemaFactory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        File file = new File(loadPath(PathContainer.FLOWERS_XSD.getField()));

        try {
            Schema schema = schemaFactory.newSchema(file);

            factory.setSchema(schema);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        reader.setFeature("http://xml.org/sax/features/namespaces", true);
        reader.setFeature("http://xml.org/sax/features/validation", true);
        reader.setFeature("http://apache.org/xml/features/validation/schema", true);
        reader.setContentHandler(handler);

        reader.setContentHandler(handler);
        reader.parse(new InputSource(loadPath(PathContainer.FLOWERS_XML.getField())));
        return reader;
    }

    private String loadPath(String fileName) {
        ClassLoader classLoader = DOMParser.class.getClassLoader();
        File file = new File(classLoader.getResource("data/" + fileName).getFile());
        return file.getPath();
    }
}
