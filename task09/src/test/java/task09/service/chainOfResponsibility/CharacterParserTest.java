package task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.CharacterComp;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.service.FileInitialization;
import by.tsvirko.task09.service.chainOfResponsibility.CharacterParser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CharacterParserTest {
    private CharacterParser parser = new CharacterParser();
    private String text;

    @BeforeTest
    public void initText() {
        text = new FileInitialization("input.txt").initialize();
    }

    @DataProvider(name = "composite_correct_data")
    public Object[] createCorrectData() {
        return new Object[]{
                " Ithassurvivednotonlyfivecenturiesbutalsotheleapintoelectronictypesettingremainingessentially"
                        + "unchangedItwaspopularisedinthewiththereleaseofLetrasetsheetscontainingLoremIpsumpassage"
                        + "sandmorerecentlywithdesktoppublishingsoftwarelikeAldusPageMakerincludingversionsofLorem"
                        + "IpsumItisalongestablishedfactthatareaderwillbedistractedbythereadablecontentofapagewhenlooki"
                        + "ngatitslayoutThepointofusingIpsumisthatithasamore-or-lessnormaldistributionoflettersasoppo"
                        + "sedtousing'Contentherecontenthere'makingitlooklikereadableEnglishItisaestablishedfactthata"
                        + "readerwillbeofapagewhenlookingatitslayoutBye"
        };
    }

    @Test(description = "Testing TextParsers' parse() and collect() method",
            dataProvider = "composite_correct_data")
    public void testCollect(String compos) {
        Composite compositeCharacter = new CharacterComp();
        Composite composite = parser.parse(compositeCharacter, text);
        String actual = composite.collect();
        String expected = compos;
        assertEquals(actual, expected);
    }
}
