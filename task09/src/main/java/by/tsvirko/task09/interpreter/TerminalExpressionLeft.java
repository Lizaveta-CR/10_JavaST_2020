package by.tsvirko.task09.interpreter;

public class TerminalExpressionLeft extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        int temp = context.popValue();
        context.pushValue(context.popValue() << temp);
    }
}
