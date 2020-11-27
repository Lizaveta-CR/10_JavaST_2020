package by.tsvirko.service.parser;

import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class DOMParser extends Parser {
    private static final Logger logger = LogManager.getLogger(DOMParser.class);

    public Document parse() throws ParserException {
        DocumentBuilder documentBuilder = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            Schema schema = null;
            try {
                schema = xsdFactory.newSchema(new File(loadPath(PathContainer.FLOWERS_XSD.getField())));
            } catch (SAXException e) {
                logger.error("Failed to create schema", e);
                throw new ParserException(e.getMessage(), e);
            }
            documentBuilderFactory.setNamespaceAware(true);
            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setSchema(schema);
            //схема подключена
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException(e.getMessage(), e);
        }
        Document document;
        try {
            document = documentBuilder.parse(new File(loadPath(PathContainer.FLOWERS_XML.getField())));
        } catch (SAXException e) {
            throw new ParserException(e.getMessage(), e);
        } catch (IOException e) {
            throw new ParserException(e.getMessage(), e);
        }
        document.getDocumentElement().normalize(); /* to ensure that the document hierarchy isn't affected
         by any extra white spaces or new lines within nodes. */
        return document;
    }

    private String loadPath(String fileName) {
        ClassLoader classLoader = DOMParser.class.getClassLoader();
        File file = new File(classLoader.getResource("data/" + fileName).getFile());
        return file.getPath();
    }
}
