package by.tsvirko.service;

import by.tsvirko.entity.CultivatedFlower;
import by.tsvirko.entity.FlowerType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import by.tsvirko.entity.GrowingTips;
import by.tsvirko.entity.VisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FlowersDOMBuilder {
    private Set<FlowerType> flowers;
    private DocumentBuilder docBuilder;

    public FlowersDOMBuilder() {
        this.flowers = new HashSet<FlowerType>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<FlowerType> getFlowers() {
        return flowers;
    }

    public void buildSetStudents(String fileName) {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList cultivatedList = root.getElementsByTagName("cultivated");

            for (int i = 0; i < cultivatedList.getLength(); i++) {
                Element flowerElement = (Element) cultivatedList.item(i);
                FlowerType flower = buildFlowerCultivated(flowerElement);
                flowers.add(flower);
            }
        } catch (SAXException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (IOException e) {
            System.err.println("Parsing failure: " + e);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private FlowerType buildFlowerCultivated(Element flowerElement) throws ParseException {
        CultivatedFlower flower = new CultivatedFlower();
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setSoil(getElementTextContent(flowerElement, "soil"));
        VisualParameters visualParameters = new VisualParameters();
        Element parameters = (Element) flowerElement.getElementsByTagName("visual_parameters").item(0);
        visualParameters.setStem_color(getElementTextContent(parameters, "stem_color"));
        visualParameters.setLeaf_color(getElementTextContent(parameters, "leaf_color"));

        Integer size = Integer.parseInt(getElementTextContent(parameters, "size"));
        visualParameters.setSize(size);
        flower.setParameters(visualParameters);
        flower.setMultiplying(getElementTextContent(flowerElement, "multiplying"));
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

        flower.setTips(growingTips);
        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
