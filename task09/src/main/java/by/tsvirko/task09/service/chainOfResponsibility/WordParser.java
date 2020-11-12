package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {
    private static final Logger logger = LogManager.getLogger(WordParser.class);
    private static final String REGEX_WORD = "[А-ЯA-Zа-яa-z-']+";
    private CharacterParser characterParser;

    public WordParser(CharacterParser characterParser) {
        this.characterParser = characterParser;
    }

    @Override
    public Composite parse(Composite compositeLexeme, String text) {
        Composite compositeWord = new Word();
        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_WORD);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(text);
        while (sentenceMatcherToLexeme.find()) {
            String word = sentenceMatcherToLexeme.group().trim();
            compositeWord = characterParser.parse(compositeWord, word);
            logger.info("compositeWord added wordLeaf");
        }
        compositeLexeme.add(compositeWord);
        logger.info("WordParser done");
        return compositeLexeme;
    }
}
