package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import by.tsvirko.task09.service.chainOfResponsibility.exception.HandlerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to parse text
 */
public class TextParser extends Parser {
    private static final Logger logger = LogManager.getLogger(TextParser.class);

    private ParagraphParser paragraphParser;
    private TextStorageRepository repository = RepositoryFactory.getInstance().getTextStorageRepository();

    public TextParser(ParagraphParser paragraphParser) {
        this.paragraphParser = paragraphParser;
    }

    /**
     * Parses text and sets text to storage in repository
     *
     * @param textComposite
     * @param text
     * @return
     * @throws HandlerException
     */
    public Composite parse(Composite textComposite, String text) throws HandlerException {
        Composite parse = paragraphParser.parse(textComposite, text);
        try {
            repository.setComponent((Component) parse.getChild(0));
        } catch (IndexOutOfBoundsException e) {
            logger.debug("Component can not be saved " + e.getMessage());
            throw new HandlerException("Component can not be saved");
        }
        logger.info("TextParser did his job");
        return parse;
    }
}
