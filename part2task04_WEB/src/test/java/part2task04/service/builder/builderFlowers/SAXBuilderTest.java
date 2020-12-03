package part2task04.service.builder.builderFlowers;

import by.tsvirko.entity.flowers.*;
import by.tsvirko.service.bulders.BaseBuilder;
import by.tsvirko.service.bulders.builderFlowers.SAXBuilder;
import by.tsvirko.service.parser.DOMParser;
import by.tsvirko.service.parser.PathContainer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class SAXBuilderTest {
    private BaseBuilder saxBuilder = new SAXBuilder();

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

        Set<String> objects = new HashSet<>();
        objects.add("leafs");
        objects.add("cuttings");
        cultivatedFlower.setMultiplying(objects);

        GrowingTips growingTips = new GrowingTips();
        growingTips.setWatering(100);

        Calendar calendar = new GregorianCalendar(2020, 8, 22);

        growingTips.setFirst_watering(calendar.getTime());
        growingTips.setLight(true);
        growingTips.setTemperature(8);
        cultivatedFlower.setTips(growingTips);

        return new Object[]{
                cultivatedFlower
        };
    }

    @Test(description = "Testing SAXBuilder' buildFlowers() method",
            dataProvider = "correct_data")
    public void testBuild(CultivatedFlower flower) {
        saxBuilder.build();

        Set<Flower> flowers = saxBuilder.getItems();
        Assert.assertTrue(flowers.contains(flower));
    }

    @Test(description = "Testing SAXBuilder' buildFlowers() method")
    public void testBuildSize() {
        saxBuilder.build();
        int size = saxBuilder.getItems().size();
        try {
            Document doc = new DOMParser().parse(PathContainer.FLOWERS_XML,PathContainer.FLOWERS_XSD);

            NodeList nodeListCultivated = doc.getElementsByTagName(FlowerEnum.CULTIVATED.getField());
            NodeList nodeListWildGrowing = doc.getElementsByTagName(FlowerEnum.WILD_GROWING.getField());
            int totalLength = nodeListCultivated.getLength() + nodeListWildGrowing.getLength();

            Assert.assertEquals(size, totalLength);
        } catch (Exception e) {
        }
    }
}
