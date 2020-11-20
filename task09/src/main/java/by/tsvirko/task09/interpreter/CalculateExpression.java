package by.tsvirko.task09.interpreter;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculateExpression {
    private ArrayList<AbstractExpression> listExpression = new ArrayList<>();

    public CalculateExpression(String expression) {
        String polishNotation = (new ReversePolishNotation()).convertToReversePolish(expression);
        parse(polishNotation);
    }

    public void parse(String expression) {
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

    public Integer calculate() {
        Context context = new Context();
        for (AbstractExpression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    public static void main(String[] args) {
        String exp = "(8^5|1&2<<(2|5>>2&71))|1200 ";
        Integer calculate = new CalculateExpression(exp).calculate();
        System.out.println("Mine =" + calculate);
        int actual = (8 ^ 5 | 1 & 2 << (2 | 5 >> 2 & 71)) | 1200;
        System.out.println("Actual =" + actual);
    }
}
