package by.tsvirko.task09.service.chainOfResponsibility;

import by.tsvirko.task09.entity.composite.Component;
import by.tsvirko.task09.entity.composite.Composite;
import by.tsvirko.task09.repository.RepositoryFactory;
import by.tsvirko.task09.repository.TextStorageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends Parser {
    private static final Logger logger = LogManager.getLogger(TextParser.class);

    private ParagraphParser paragraphParser;
    private TextStorageRepository repository = RepositoryFactory.getInstance().getTextStorageRepository();

    public TextParser(ParagraphParser paragraphParser) {
        this.paragraphParser = paragraphParser;
    }

    public Composite parse(Composite textComposite, String text) {
        Composite parse = paragraphParser.parse(textComposite, text);
        repository.setComponent((Component) parse.getChild(0));
        logger.info("TextParser did his job");
        return parse;
    }
}
