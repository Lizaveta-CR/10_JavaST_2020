package by.tsvirko.task09.entity.chainOfResponsibility;

public class TextParser extends Parser {
    private ParagraphParser paragraphParser;

    public TextParser(ParagraphParser paragraphParser) {
        this.paragraphParser = paragraphParser;
    }

    void parse() {

    }
}
