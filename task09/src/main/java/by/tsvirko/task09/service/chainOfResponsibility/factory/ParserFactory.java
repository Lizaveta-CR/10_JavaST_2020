package by.tsvirko.task09.service.chainOfResponsibility.factory;

import by.tsvirko.task09.service.chainOfResponsibility.*;

public class ParserFactory {
    private static final ParserFactory factory = new ParserFactory();

    private Parser parser = new TextParser(new ParagraphParser(new SentenceParser(new LexemeParser(new WordParser(new CharacterParser())))));

    public static ParserFactory getFactory() {
        return factory;
    }

    public Parser getParser() {
        return parser;
    }
}
