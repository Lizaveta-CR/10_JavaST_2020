package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Parser {
    private static final Logger logger = LogManager.getLogger(LexemeParser.class);
    private static final String REGEX_LEXEME = "((\\s*)([А-ЯA-Zа-яa-z-(')])*(\\p{Blank}|\\p{Punct})|(\\p{Punct}\\p{Blank}))";
    private static final String REGEX_PUNCTUATION = "(?!['-])\\p{Punct}";
    private WordParser wordParser;

    public LexemeParser(WordParser wordParser) {
        this.wordParser = wordParser;
    }

    @Override
    public Composite parse(Composite compositeSentence, String text) {
        Composite compositeLexeme = new Lexeme();
        Component characterLeaf;
        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_LEXEME);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(text);
        Pattern lexemePatternToPunctuation = Pattern.compile(REGEX_PUNCTUATION);

        while (sentenceMatcherToLexeme.find()) {
            String lexeme = sentenceMatcherToLexeme.group().trim();
            compositeLexeme = wordParser.parse(compositeLexeme, lexeme);

            Matcher lexemeMatcherToPunctuation = lexemePatternToPunctuation.matcher(lexeme);
            while (lexemeMatcherToPunctuation.find()) {
                String punctuation = lexemeMatcherToPunctuation.group().trim();
                characterLeaf = new CharacterLeaf(punctuation.charAt(0));
                compositeLexeme.add(characterLeaf);
            }
            logger.info("compositeLexeme added compositeLexeme");
        }
        compositeSentence.add(compositeLexeme);
        logger.info("LexemeParser done");
        return compositeSentence;
    }

    public static void main(String[] args) {
        String text = "The point of using Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.";
        Pattern compile = Pattern.compile(REGEX_LEXEME);
        Matcher matcher = compile.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
