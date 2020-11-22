package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for parsing sentences.
 */
public class SentenceParser extends Parser {
    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
        private static final String REGEX_SENTENCE = "((\\s*)[А-ЯA-Z]([^?!.])*([.?!]*([!?...])))";
    private LexemeParser lexemeParser;

    public SentenceParser(LexemeParser lexemeParser) {
        this.lexemeParser = lexemeParser;
    }

    /**
     * Parses paragraph into sentences
     * @param compositeParagraph
     * @param paragraph
     * @return paragraph composite
     * @throws HandlerException
     */
    @Override
    public Composite parse(Composite compositeParagraph, String paragraph) throws HandlerException {
        Composite compositeSentence = new Sentence();
        Pattern paragraphPatternToSentence = Pattern.compile(REGEX_SENTENCE);
        Matcher paragraphMatcherToSentence = paragraphPatternToSentence.matcher(paragraph);

        while (paragraphMatcherToSentence.find()) {
            String sentence = paragraphMatcherToSentence.group();
            compositeSentence = lexemeParser.parse(compositeSentence, sentence);
        }
        compositeParagraph.add(compositeSentence);
        logger.info("ParagraphParser done");
        return compositeParagraph;
    }
}
