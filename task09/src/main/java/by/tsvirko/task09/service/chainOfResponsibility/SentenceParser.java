package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String REGEX_SENTENCE = "((\\s*)[А-ЯA-Z]([^?!.])*([.?!]*([!?...])))";

    @Override
    public Composite parse(Composite compositeParagraph, String text) {
        Composite compositeSentence = new Sentence();
        Component sentenceLeaf;
        Pattern paragraphPatternToSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher paragraphMatcherToSentence = paragraphPatternToSentence.matcher(text);
        while (paragraphMatcherToSentence.find()) {
            String sentence = paragraphMatcherToSentence.group().trim();
            sentenceLeaf = new SentenceLeaf(sentence);
            compositeSentence.add(sentenceLeaf);
            logger.info("compositeSentence added sentenceLeaf");
        }
        compositeParagraph.add(compositeSentence);
        logger.info("SentenceParser done");
        return compositeParagraph;
    }
}
