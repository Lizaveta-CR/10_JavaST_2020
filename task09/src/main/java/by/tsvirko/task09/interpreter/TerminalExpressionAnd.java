package by.tsvirko.task09.interpreter;

public class TerminalExpressionAnd extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() & context.popValue());
    }
}
