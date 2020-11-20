package by.tsvirko.task09.interpreter;

//содержит ссылку на следующий объект типа TerminalExpression и вызывает, если необходимо, методы interpret() для других подклассов
public class NonTerminalExpressionNumber extends AbstractExpression {
    private int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    public void interpret(Context context) {
        context.pushValue(number);
    }
}
