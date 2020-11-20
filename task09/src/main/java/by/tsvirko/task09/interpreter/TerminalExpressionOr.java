package by.tsvirko.task09.interpreter;

public class TerminalExpressionOr extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() | context.popValue());
    }
}
