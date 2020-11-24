package by.tsvirko.service.builder;

import by.tsvirko.entity.CultivatedFlower;
import by.tsvirko.entity.Flower;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import by.tsvirko.entity.GrowingTips;
import by.tsvirko.entity.VisualParameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMBuilder extends BaseBuilder {
    private static final Logger logger = LogManager.getLogger(DOMBuilder.class);

    private DocumentBuilder docBuilder;

    public DOMBuilder() {
        this.flowers = new HashSet<Flower>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.debug("Parsers configuration exception " + e);
        }
    }

    @Override
    public void buildFlowers(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList cultivatedList = root.getElementsByTagName("cultivated");

            for (int i = 0; i < cultivatedList.getLength(); i++) {
                Element flowerElement = (Element) cultivatedList.item(i);
                Flower flower = buildCultivatedFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (SAXException e) {
            logger.debug("File error or I/O error: " + e);
        } catch (IOException e) {
            logger.debug("Parsing failure: " + e);
        } catch (ParseException e) {
            logger.debug("ParseException " + e.getMessage());
        }
    }

    private Flower buildCultivatedFlower(Element flowerElement) throws ParseException {
        CultivatedFlower flower = new CultivatedFlower();
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setSoil(getElementTextContent(flowerElement, "soil"));

        VisualParameters visualParameters = buildVisual(flowerElement);
        flower.setParameters(visualParameters);

        flower.setMultiplying(getElementTextContent(flowerElement, "multiplying"));

        GrowingTips growingTips = buildGrowing(flowerElement);
        flower.setTips(growingTips);
        return flower;
    }

    private VisualParameters buildVisual(Element flowerElement) {
        VisualParameters visualParameters = new VisualParameters();
        Element parameters = (Element) flowerElement.getElementsByTagName("visual_parameters").item(0);
        visualParameters.setStem_color(getElementTextContent(parameters, "stem_color"));
        visualParameters.setLeaf_color(getElementTextContent(parameters, "leaf_color"));

        Integer size = Integer.parseInt(getElementTextContent(parameters, "size"));
        visualParameters.setSize(size);
        return visualParameters;
    }

    private GrowingTips buildGrowing(Element flowerElement) throws ParseException {
        GrowingTips growingTips = new GrowingTips();
        Element tips = (Element) flowerElement.getElementsByTagName("growing_tips").item(0);
        Integer temperature = Integer.parseInt(getElementTextContent(tips, "temperature"));
        growingTips.setTemperature(temperature);
        growingTips.setLight(getElementTextContent(tips, "light"));

        Date firstWatering = new SimpleDateFormat("yyyy-MM-dd")
                .parse((getElementTextContent(tips, "first_watering")));
        growingTips.setFirst_watering(firstWatering);

        double watering = Double.parseDouble(getElementTextContent(tips, "watering"));
        growingTips.setWatering(watering);
        return growingTips;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
