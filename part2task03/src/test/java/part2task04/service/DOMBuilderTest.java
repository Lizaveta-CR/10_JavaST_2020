package part2task04.service;

import by.tsvirko.entity.*;
import by.tsvirko.service.builder.BaseBuilder;
import by.tsvirko.service.builder.DOMBuilder;
import by.tsvirko.service.parser.DOMParserImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.*;

public class DOMBuilderTest {
    private BaseBuilder domBuilder = new DOMBuilder();

    @DataProvider(name = "correct_data")
    public Object[] symbolData() {
        CultivatedFlower cultivatedFlower = new CultivatedFlower();
        cultivatedFlower.setName("Orchid");
        cultivatedFlower.setOrigin("CN");
        cultivatedFlower.setSoil(Soil.PODZOLIC);
        cultivatedFlower.setId("c-1");

        VisualParameters visualParameters = new VisualParameters();
        visualParameters.setStem_color("Green");
        visualParameters.setLeaf_color("Pink");
        visualParameters.setSize(70);
        cultivatedFlower.setParameters(visualParameters);

        List<String> objects = new ArrayList<>();
        objects.add("leafs");
        cultivatedFlower.setMultiplying(objects);

        GrowingTips growingTips = new GrowingTips();
        growingTips.setWatering(100);

        Calendar calendar = new GregorianCalendar(2020, 8, 22);

        growingTips.setFirst_watering(calendar.getTime());
        growingTips.setLight("diffused");
        growingTips.setTemperature(8);
        cultivatedFlower.setTips(growingTips);

        return new Object[]{
                cultivatedFlower
        };
    }

    @Test(description = "Testing DOMBuilder' buildFlowers() method",
            dataProvider = "correct_data")
    public void testBuild(CultivatedFlower flower) {
        domBuilder.buildFlowers();

        Set<Flower> flowers = domBuilder.getFlowers();
        Assert.assertTrue(flowers.contains(flower));
    }

    @Test(description = "Testing DOMBuilder' buildFlowers() method",
            dataProvider = "files")
    public void testBuildSize(String inputFile) {
        domBuilder.buildFlowers();
        int size = domBuilder.getFlowers().size();
        try {

            Document doc = new DOMParserImpl().parse();

            NodeList nodeListCultivated = doc.getElementsByTagName(FlowerEnum.CULTIVATED_FLOWER.getField());
            NodeList nodeListWildGrowing = doc.getElementsByTagName(FlowerEnum.WILD_GROWING_FLOWER.getField());
            int totalLength = nodeListCultivated.getLength() + nodeListWildGrowing.getLength();

            Assert.assertEquals(size, totalLength);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
