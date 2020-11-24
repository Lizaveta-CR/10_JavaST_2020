package by.tsvirko.service.builder;

import by.tsvirko.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import by.tsvirko.service.parser.DOMParserImpl;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMBuilder extends BaseBuilder {
    private static final Logger logger = LogManager.getLogger(DOMBuilder.class);
    private DOMParserImpl domParser;

    public DOMBuilder() {
        this.flowers = new HashSet<Flower>();
        domParser = new DOMParserImpl();
    }

    @Override
    public void buildFlowers() {
        Document doc = null;
        try {
            doc = domParser.parse();
            Element root = doc.getDocumentElement();

            NodeList cultivatedList = root.getElementsByTagName("cultivated");
            NodeList wildGrowingList = root.getElementsByTagName("wild_growing");

            for (int i = 0; i < cultivatedList.getLength(); i++) {
                Element flowerElement = (Element) cultivatedList.item(i);
                Flower flower = buildCultivatedFlower(flowerElement);
                flowers.add(flower);
            }
            for (int i = 0; i < wildGrowingList.getLength(); i++) {
                Element flowerElement = (Element) wildGrowingList.item(i);
                Flower flower = buildWildGrowingFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (ParseException e) {
            logger.debug("ParseException " + e.getMessage());
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }

    private Flower buildWildGrowingFlower(Element flowerElement) {
        WildGrowingFlower flower = new WildGrowingFlower();
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setId(flowerElement.getAttribute("id"));

        flower.setSoil(Soil.getSoil(flowerElement.getAttribute("soil")));

        VisualParameters visualParameters = buildVisual(flowerElement);
        flower.setParameters(visualParameters);

        flower.setMultiplying(getElementTextContent(flowerElement, "multiplying"));
        flower.setOrigin(getElementTextContent(flowerElement, "origin"));

        Integer life_term = Integer.parseInt(getElementTextContent(flowerElement, "life_term"));
        flower.setLife_term(life_term);

        return flower;
    }

    private Flower buildCultivatedFlower(Element flowerElement) throws ParseException {
        CultivatedFlower flower = new CultivatedFlower();
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setId(flowerElement.getAttribute("id"));

        flower.setSoil(Soil.getSoil(flowerElement.getAttribute("soil")));

        VisualParameters visualParameters = buildVisual(flowerElement);
        flower.setParameters(visualParameters);

        flower.setMultiplying(getElementTextContent(flowerElement, "multiplying"));

        flower.setOrigin(getElementTextContent(flowerElement, "origin"));

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
