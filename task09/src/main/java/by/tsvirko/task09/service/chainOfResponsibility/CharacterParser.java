package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterParser extends Parser {
    private static final Logger logger = LogManager.getLogger(CharacterParser.class);

    @Override
    public Composite parse(Composite compositeWord, String word) {
        Composite compositeCharacter = new CharacterComp();
        Component characterLeaf;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            characterLeaf = new CharacterLeaf(chars[i]);
            compositeCharacter.add(characterLeaf);
        }
        compositeWord.add(compositeCharacter);
        logger.info("WordParser done");
        return compositeWord;
    }
}
