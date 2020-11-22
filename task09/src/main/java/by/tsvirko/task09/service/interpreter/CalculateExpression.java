package by.tsvirko.task09.service.interpreter;

import by.tsvirko.task09.service.interpreter.exception.NoExpressionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calculates given expression
 */
public class CalculateExpression {
    private ArrayList<AbstractExpression> listExpression = new ArrayList<>();

    /**
     * CalculateExpression's constructor,
     * which validates expression, calculates reverse polish notation and parses
     *
     * @param expression
     * @throws NoExpressionException
     */
    public CalculateExpression(String expression) throws NoExpressionException {
        if (expression == null || expression.isEmpty()) {
            throw new NoExpressionException("No expression has been found");
        }
        String polishNotation = (new ReversePolishNotation()).convertToReversePolish(expression);
        parse(polishNotation);
    }

    private void parse(String expression) {
        for (String lexeme : expression.split("\\p{Blank}+")) {
            if (lexeme.isEmpty()) {
                continue;
            }
            String temp = lexeme;
            switch (temp) {
                case "~":
                    listExpression.add(new TerminalExpressionNot());
                    break;
                case "&":
                    listExpression.add(new TerminalExpressionAnd());
                    break;
                case "|":
                    listExpression.add(new TerminalExpressionOr());
                    break;
                case "^":
                    listExpression.add(new TerminalExpressionExcludedOr());
                    break;
                case ">>":
                    listExpression.add(new TerminalExpressionRight());
                    break;
                case "<<":
                    listExpression.add(new TerminalExpressionLeft());
                    break;
                case ">>>":
                    listExpression.add(new TerminalExpressionRightZero());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        listExpression.add(new NonTerminalExpressionNumber(scanner.nextInt()));
                    }
                    break;
            }
        }
    }

    /**
     * Calculates expression
     *
     * @return
     */
    public int calculate() {
        Context context = new Context();
        for (AbstractExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
