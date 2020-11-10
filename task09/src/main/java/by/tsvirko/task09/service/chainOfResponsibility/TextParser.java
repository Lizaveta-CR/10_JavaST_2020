package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends Parser {
    private static final Logger logger = LogManager.getLogger(TextParser.class);

    private ParagraphParser paragraphParser;

    public TextParser(ParagraphParser paragraphParser) {
        this.paragraphParser = paragraphParser;
    }

    public Composite parse(Composite textComposite, String text) {
        logger.info("TextParser did his job");
        return paragraphParser.parse(textComposite, text);
    }
}
