package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lexeme parser.
 */
public class LexemeParser extends Parser {
    private static final Logger logger = LogManager.getLogger(LexemeParser.class);
    private static final String REGEX_LEXEME = "((\\s*)([[А-ЯA-Zа-яa-z-'\\(\\)]|"
            + "((\\()?(\\~)?\\d+)([\\(|\\)|\\~|\\(|\\)|\\>|\\<|\\~|\\&|\\||\\^]*[\\d+|\\)])*])"
            + "*(\\p{Blank}|\\p{Punct})|(\\p{Punct}\\p{Blank}))";
    private static final String REGEX_PUNCTUATION = "(?![\\<\\>[\\(0-9\\)]\\~\\>\\&\\^\\|'-])\\p{Punct}";
    private WordParser wordParser;

    public LexemeParser(WordParser wordParser) {
        this.wordParser = wordParser;
    }

    /**
     * Parses sentence into words and punctuation
     * @param compositeSentence
     * @param sentence
     * @return sentence composite
     * @throws HandlerException
     */
    @Override
    public Composite parse(Composite compositeSentence, String sentence) throws HandlerException {
        Composite compositeLexeme = new Lexeme();
        Component characterLeaf;
        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_LEXEME);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(sentence);
        Pattern lexemePatternToPunctuation = Pattern.compile(REGEX_PUNCTUATION);

        while (sentenceMatcherToLexeme.find()) {
            String lexeme = sentenceMatcherToLexeme.group().trim();
            compositeLexeme = wordParser.parse(compositeLexeme, lexeme);

            Matcher lexemeMatcherToPunctuation = lexemePatternToPunctuation.matcher(lexeme);
            while (lexemeMatcherToPunctuation.find()) {
                String punctuation = lexemeMatcherToPunctuation.group();
                characterLeaf = new CharacterLeaf(punctuation.charAt(0));
                compositeLexeme.add(characterLeaf);
            }
        }
        compositeSentence.add(compositeLexeme);
        logger.info("LexemeParser done");
        return compositeSentence;
    }
}
