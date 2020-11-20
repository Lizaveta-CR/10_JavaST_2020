package by.tsvirko.task09.interpreter;

import java.util.ArrayDeque;

//исходные числовые значения выражения, а также результаты промежуточных вычислений и конечный результат
public class Context {
    private ArrayDeque<Integer> contextValues = new ArrayDeque();

    public Context() {
    }

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        contextValues.push(value);
    }
}
