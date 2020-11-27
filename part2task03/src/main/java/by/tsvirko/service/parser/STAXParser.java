package by.tsvirko.service.parser;

import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class STAXParser {
    private static final Logger logger = LogManager.getLogger(STAXParser.class);

    private XMLInputFactory inputFactory;

    public XMLStreamReader parse() throws ParserException, IOException, SAXException {
        String schemaLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(schemaLang);
        File xsdFile = new File(loadPath(PathContainer.FLOWERS_XSD.getField()));
        Schema schema = schemaFactory.newSchema(xsdFile);
        Validator validator = schema.newValidator();
        XMLStreamReader xmlStreamReaderValidate = null;
        XMLStreamReader xmlStreamReaderParse = null;
        try {
            xmlStreamReaderValidate = XMLInputFactory
                    .newInstance()
                    .createXMLStreamReader(new FileInputStream(loadPath(PathContainer.FLOWERS_XML.getField())));
            StAXSource staxSource = new StAXSource(xmlStreamReaderValidate);
            validator.validate(staxSource);
            xmlStreamReaderParse = XMLInputFactory
                    .newInstance()
                    .createXMLStreamReader(new FileInputStream(loadPath(PathContainer.FLOWERS_XML.getField())));
        } catch (XMLStreamException e) {
            logger.info("XMLStreamException while creating reader for STAX", e.getMessage());
        }

        return xmlStreamReaderParse;
    }

    private String loadPath(String fileName) {
        ClassLoader classLoader = DOMParser.class.getClassLoader();
        File file = new File(classLoader.getResource("data/" + fileName).getFile());
        return file.getPath();
    }
}
