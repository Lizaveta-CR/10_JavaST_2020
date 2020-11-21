package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import by.tsvirko.task09.service.interpreter.CalculateExpression;
import by.tsvirko.task09.service.interpreter.exception.NoExpressionException;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {
    private static final Logger logger = LogManager.getLogger(WordParser.class);
    private static final String REGEX_WORD = "[А-ЯA-Zа-яa-z-'\\)\\)" +
            "|((\\()?(\\~)?\\d+)([\\(|\\)|\\~|\\(|\\)|\\>|\\<|\\~|\\&|\\||\\^]*[\\d+|\\)])*]+";
    private static final String REGEX_EXPRESSION =
            "((\\()?(\\~)?\\d+)([\\(|\\)|\\~|\\(|\\)|\\>|\\<|\\~|\\&|\\||\\^]*[\\d+|\\)])*";
    private CharacterParser characterParser;

    public WordParser(CharacterParser characterParser) {
        this.characterParser = characterParser;
    }

    @Override
    public Composite parse(Composite compositeLexeme, String lexeme) throws HandlerException {
        Composite compositeWord = new Word();
        Component numericLeaf;
        Pattern lexemePatternToWord = Pattern.compile(REGEX_WORD);
        Pattern wordPatternToCharacter = Pattern.compile(REGEX_EXPRESSION);
        Matcher lexemeMatcherToWord = lexemePatternToWord.matcher(lexeme);

        while (lexemeMatcherToWord.find()) {
            String word = lexemeMatcherToWord.group();

            if (!word.matches(REGEX_EXPRESSION)) {
                compositeWord = characterParser.parse(compositeWord, word);
            }

            Matcher wordMatcherToCharacter = wordPatternToCharacter.matcher(word);
            while (wordMatcherToCharacter.find()) {
                String exp = wordMatcherToCharacter.group();
                try {
                    numericLeaf = new NumericLeaf(new CalculateExpression(exp).calculate());
                    compositeWord.add(numericLeaf);
                } catch (NoExpressionException e) {
                    throw new HandlerException();
                }
            }
        }
        compositeLexeme.add(compositeWord);
        logger.info("WordParser done");
        return compositeLexeme;
    }
}
