package by.tsvirko.service.bulders.builderFlowers;

import by.tsvirko.entity.flowers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class FlowerHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(FlowerHandler.class);

    protected Set<Flower> flowers;
    private WildGrowingFlower currentWild = null;
    private CultivatedFlower currentCultivated = null;
    private FlowerEnum currentEnum = null;
    private EnumSet<FlowerEnum> withText;
    private Set<String> multiplyingCultivated;
    private Set<String> multiplyingWild;
    private String name = "";

    public FlowerHandler() {
        withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.FIRST_WATERING);
        flowers = new HashSet<>();
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("wild_growing".equals(localName)) {
            name = FlowerEnum.WILD_GROWING.getField();
            currentWild = new WildGrowingFlower();
            multiplyingWild = new HashSet<>();
            currentWild.setId(attributes.getValue(FlowerEnum.ID.getField()));
            currentWild.setSoil(Soil.getSoil(attributes.getValue(FlowerEnum.SOIL.getField())));
        } else if ("cultivated".equals(localName)) {
            name = FlowerEnum.CULTIVATED.getField();
            currentCultivated = new CultivatedFlower();
            multiplyingCultivated = new HashSet<>();
            currentCultivated.setId(attributes.getValue(FlowerEnum.ID.getField()));
            currentCultivated.setSoil(Soil.getSoil(attributes.getValue(FlowerEnum.SOIL.getField())));
        } else {
            FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("wild_growing".equals(localName)) {
            currentWild.setMultiplying(multiplyingWild);
            flowers.add(currentWild);
        }
        if ("cultivated".equals(localName)) {
            currentCultivated.setMultiplying(multiplyingCultivated);
            flowers.add(currentCultivated);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String currentElem = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        currentCultivated.setName(currentElem);
                    } else {
                        currentWild.setName(currentElem);
                    }
                    break;
                case ORIGIN:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        currentCultivated.setOrigin(currentElem);
                    } else {
                        currentWild.setOrigin(currentElem);
                    }
                    break;
                case STEM_COLOR:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        currentCultivated.getParameters().setStem_color(currentElem);
                    } else {
                        currentWild.getParameters().setStem_color(currentElem);
                    }
                    break;
                case LEAF_COLOR:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        currentCultivated.getParameters().setLeaf_color(currentElem);
                    } else {
                        currentWild.getParameters().setLeaf_color(currentElem);
                    }
                    break;
                case SIZE:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        currentCultivated.getParameters().setSize(Integer.parseInt(currentElem));
                    } else {
                        currentWild.getParameters().setSize(Integer.parseInt(currentElem));
                    }
                    break;
                case MULTIPLYING:
                    if (name.equals(FlowerEnum.CULTIVATED.getField())) {
                        multiplyingCultivated.add(currentElem);
                    } else {
                        multiplyingWild.add(currentElem);
                    }
                    break;
                case LIFE_TERM:
                    currentWild.setLife_term(Integer.parseInt(currentElem));
                    break;
                case TEMPERATURE:
                    currentCultivated.getTips().setTemperature(Integer.parseInt(currentElem));
                    break;
                case LIGHT:
                    currentCultivated.getTips().setLight(Boolean.parseBoolean(currentElem));
                    break;
                case FIRST_WATERING:
                    try {
                        Date firstWatering = new SimpleDateFormat("yyyy-MM-dd")
                                .parse(currentElem);
                        currentCultivated.getTips().setFirst_watering(firstWatering);
                    } catch (ParseException e) {
                        logger.info("Can not parse date: " + e.getMessage());
                    }
                    break;
                case WATERING:
                    currentCultivated.getTips().setWatering(Double.parseDouble(currentElem));
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
