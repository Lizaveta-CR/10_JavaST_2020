package by.tsvirko.service.bulders.builderFlowers;

import by.tsvirko.entity.flowers.*;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.parser.PathContainer;
import by.tsvirko.service.parser.STAXParser;
import by.tsvirko.service.parser.exception.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class STAXBuilder extends BaseBuilder<Flower> {
    private static final Logger logger = LogManager.getLogger(STAXBuilder.class);

    private XMLStreamReader reader;


    public STAXBuilder() {
        super();
        try {
            reader = new STAXParser().parse(PathContainer.FLOWERS_XML,PathContainer.FLOWERS_XSD);
        } catch (ParserException | IOException | SAXException e) {
            logger.error("STAXBuilder parsing failed!", e.getMessage());
        }
    }

    @Override
    public void build() {
        String name;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        Flower cultivated = buildCultivated(reader, new CultivatedFlower());
                        items.add(cultivated);
                    }
                    if (name.equals(FlowerEnum.WILD_GROWING.getField())) {
                        Flower wild = buildWild(reader, new WildGrowingFlower());
                        items.add(wild);
                    }
                }
            }
        } catch (XMLStreamException | ParseException e) {
            logger.debug("StAX parsing error! ", e);
        }
    }

    private Flower buildCultivated(XMLStreamReader reader, CultivatedFlower flower) throws XMLStreamException, ParseException {
        flower.setId(reader.getAttributeValue(null, FlowerEnum.ID.getField()));

        //TODO:connect schema
        if ((reader.getAttributeValue(null, FlowerEnum.SOIL.getField())) != null) {
            flower.setSoil(Soil.getSoil(reader.getAttributeValue(null, FlowerEnum.SOIL.getField())));
        } else {
            flower.setSoil(Soil.GROUND);
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            flower.setName(getXMLText(reader));
                            break;
                        case ORIGIN:
                            flower.setOrigin(getXMLText(reader));
                            break;
                        case VISUAL_PARAMETERS:
                            flower.setParameters(getXMLVisual(reader));
                            break;
                        case MULTIPLYING:
                            String item = getXMLText(reader);
                            flower.getMultiplying().add(item);
                            break;
                        case GROWING_TIPS:
                            flower.setTips(getXMLGrowing(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName().toUpperCase();
                    FlowerEnum flowerEnum = FlowerEnum.valueOf(name);
                    if (flowerEnum == FlowerEnum.CULTIVATED) {
                        return flower;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element");
    }

    private Flower buildWild(XMLStreamReader reader, WildGrowingFlower flower) throws XMLStreamException {
        flower.setId(reader.getAttributeValue(null, FlowerEnum.ID.getField()));

        //TODO:connect schema
        if ((reader.getAttributeValue(null, FlowerEnum.SOIL.getField())) != null) {
            flower.setSoil(Soil.getSoil(reader.getAttributeValue(null, FlowerEnum.SOIL.getField())));
        } else {
            flower.setSoil(Soil.GROUND);
        }

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            flower.setName(getXMLText(reader));
                            break;
                        case ORIGIN:
                            flower.setOrigin(getXMLText(reader));
                            break;
                        case VISUAL_PARAMETERS:
                            flower.setParameters(getXMLVisual(reader));
                            break;
                        case MULTIPLYING:
                            String item = getXMLText(reader);
                            flower.getMultiplying().add(item);
                            break;
                        case LIFE_TERM:
                            flower.setLife_term(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName().toUpperCase();
                    FlowerEnum flowerEnum = FlowerEnum.valueOf(name);
                    if (flowerEnum == FlowerEnum.WILD_GROWING) {
                        return flower;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element");
    }

    private GrowingTips getXMLGrowing(XMLStreamReader reader) throws XMLStreamException, ParseException {
        GrowingTips growing = new GrowingTips();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case TEMPERATURE:
                            growing.setTemperature(Integer.parseInt(getXMLText(reader)));
                            break;
                        case LIGHT:
                            growing.setLight(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case WATERING:
                            growing.setWatering(Integer.parseInt(getXMLText(reader)));
                            break;
                        case FIRST_WATERING:
                            Date firstWatering = new SimpleDateFormat("yyyy-MM-dd")
                                    .parse((getXMLText(reader)));
                            growing.setFirst_watering(firstWatering);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.GROWING_TIPS) {
                        return growing;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag growing-tips");
    }

    private VisualParameters getXMLVisual(XMLStreamReader reader) throws XMLStreamException {
        VisualParameters visual = new VisualParameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case LEAF_COLOR:
                            visual.setLeaf_color(getXMLText(reader));
                            break;
                        case STEM_COLOR:
                            visual.setStem_color(getXMLText(reader));
                            break;
                        case SIZE:
                            visual.setSize(Integer.parseInt(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.VISUAL_PARAMETERS) {
                        return visual;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag visual");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
