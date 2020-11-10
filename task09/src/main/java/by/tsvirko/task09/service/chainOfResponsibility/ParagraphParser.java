package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Paragraph;
import by.tsvirko.task09.entity.composite.ParagraphLeaf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser {
    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private static final String REGEX_PARAGRAPH = "((\t)[^\t|#{2}]+)";

    public Composite parse(Composite compositeText, String text) {
        Composite compositeParagraph = new Paragraph();
        Component paragraphLeaf;
        Pattern textPatternToParagraph = Pattern.compile(REGEX_PARAGRAPH);
        Matcher textMatcherToParagraph = textPatternToParagraph.matcher(text);

        while (textMatcherToParagraph.find()) {
            String paragraphAndListing = textMatcherToParagraph.group().trim();
            paragraphLeaf = new ParagraphLeaf(paragraphAndListing);
            compositeParagraph.add(paragraphLeaf);
            logger.info("compositeParagraph added paragraphLeaf");
        }
        compositeText.add(compositeParagraph);
        logger.info("ParagraphParser done");
        return compositeText;
    }
}
