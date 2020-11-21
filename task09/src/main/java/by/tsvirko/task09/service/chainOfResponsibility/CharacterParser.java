package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterParser extends Parser {
    private static final Logger logger = LogManager.getLogger(CharacterParser.class);
    //    private static final String REGEX_CHARACTER = "(?![[\\(0-9\\)]|\\|])[А-ЯA-Zа-яa-z-'-]";
    //TODO:
    private static final String REGEX_CHARACTER = "[А-ЯA-Zа-яa-z-'-\\(\\)]";


    @Override
    public Composite parse(Composite compositeWord, String word) {
        Composite compositeCharacter = new CharacterComp();
        Component characterLeaf;

        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_CHARACTER);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(word);
        while (sentenceMatcherToLexeme.find()) {
            String character = sentenceMatcherToLexeme.group();
            characterLeaf = new CharacterLeaf(character.charAt(0));
            compositeCharacter.add(characterLeaf);
        }
        compositeWord.add(compositeCharacter);
        logger.info("CharacterParser done");
        return compositeWord;
    }

    public static void main(String[] args) {
        String exp = "not only (five) centuries, but also the leap into ";
        Pattern sentencePatternToLexeme = Pattern.compile(REGEX_CHARACTER);
        Matcher sentenceMatcherToLexeme = sentencePatternToLexeme.matcher(exp);
        while (sentenceMatcherToLexeme.find()) {
            String group = sentenceMatcherToLexeme.group();
            System.out.println(group);
//            System.out.println(group.equals(expr));
        }
    }
}
