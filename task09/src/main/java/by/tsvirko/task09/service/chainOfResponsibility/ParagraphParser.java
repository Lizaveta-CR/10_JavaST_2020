package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.entity.composite.Paragraph;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Paragraph parser.
 */
public class ParagraphParser extends Parser {
    private static final Logger logger = LogManager.getLogger(ParagraphParser.class);
    private static final String REGEX_PARAGRAPH = "((\t)(.*)?)[^\t|#{2}]+";
    private SentenceParser sentenceParser;

    public ParagraphParser(SentenceParser sentenceParser) {
        this.sentenceParser = sentenceParser;
    }

    /**
     * Parses text into paragraphs
     *
     * @param compositeText
     * @param text
     * @return text composite
     * @throws HandlerException
     */
    public Composite parse(Composite compositeText, String text) throws HandlerException {
        Composite compositeParagraph = new Paragraph();
        Pattern textPatternToParagraph = Pattern.compile(REGEX_PARAGRAPH);
        Matcher textMatcherToParagraph = textPatternToParagraph.matcher(text);

        while (textMatcherToParagraph.find()) {
            String paragraphAndListing = textMatcherToParagraph.group();
            compositeParagraph = sentenceParser.parse(compositeParagraph, paragraphAndListing);
        }
        compositeText.add(compositeParagraph);
        logger.info("ParagraphParser done");
        return compositeText;
    }
}
