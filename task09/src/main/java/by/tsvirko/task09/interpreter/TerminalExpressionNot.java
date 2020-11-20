package by.tsvirko.task09.interpreter;

public class TerminalExpressionNot extends AbstractExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(~context.popValue());
    }
}
