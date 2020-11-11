package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {
    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String REGEX_SENTENCE = "((\\s*)[А-ЯA-Z]([^?!.])*([.?!]*([!?...])))";
    private LexemeParser lexemeParser;

    public SentenceParser(LexemeParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    @Override
    public Composite parse(Composite compositeParagraph, String text) {
        Composite compositeSentence = new Sentence();
        Pattern paragraphPatternToSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher paragraphMatcherToSentence = paragraphPatternToSentence.matcher(text);

        while (paragraphMatcherToSentence.find()) {
            String sentence = paragraphMatcherToSentence.group().trim();
            compositeSentence = lexemeParser.parse(compositeSentence, sentence);
            logger.info("compositeParagraph added paragraphLeaf");
        }
        compositeParagraph.add(compositeSentence);
        logger.info("ParagraphParser done");
        return compositeParagraph;
    }
}
