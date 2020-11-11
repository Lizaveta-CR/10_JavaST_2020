package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Parser {
    private static final Logger logger = LogManager.getLogger(LexemeParser.class);
    private static final String REGEX_LEXEME = "((\\s*)([А-ЯA-Zа-яa-z-(')])*(\\p{Blank}|\\p{Punct})|(\\p{Punct}\\p{Blank}))";

    @Override
    public Composite parse(Composite compositeSentence, String text) {
        Composite compositeLexeme = new Lexeme();
        Component lexemeLeaf;
        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_LEXEME);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(text);
        while (sentenceMatcherToLexeme.find()) {
            String lexeme = sentenceMatcherToLexeme.group().trim();
            lexemeLeaf = new LexemeLeaf(lexeme);
            compositeLexeme.add(lexemeLeaf);
            logger.info("compositeLexeme added lexemeLeaf");
        }
        compositeSentence.add(compositeLexeme);
        logger.info("LexemeParser done");
        return compositeSentence;
    }
}
