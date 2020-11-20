package by.tsvirko.task09.interpreter;

public class TerminalExpressionRight extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        int temp = context.popValue();
        context.pushValue(context.popValue() >> temp);
    }
}
