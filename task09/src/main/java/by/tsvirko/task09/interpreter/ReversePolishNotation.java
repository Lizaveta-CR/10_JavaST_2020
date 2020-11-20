package by.tsvirko.task09.interpreter;

import java.util.Stack;

public class ReversePolishNotation {

    public String convertToReversePolish(String exp) {
        if (exp == null)
            return null;
        String res = "";
        int len = exp.length();
        Stack<String> operator = new Stack<String>();
        Stack<String> reversePolish = new Stack<String>();

        //avoid checking empty
        operator.push("#");
        for (int i = 0; i < len; ) {
            //deal with space
            while (i < len && exp.substring(i, i + 1).equals(" "))
                i++;
            if (i == len)
                break;
            //if is number
            if (isNum(exp.charAt(i))) {
                String num = "";
                while (i < len && isNum(exp.charAt(i)))
                    num += exp.charAt(i++);
                reversePolish.push(num);
                //is operator
            } else {
                String op = "";
                try {
                    if (isOperator(exp.substring(i, i + 1))) {
                        op = exp.substring(i, i + 1);
                    } else if (isOperator(exp.substring(i, i + 2))) {
                        if (isOperator(exp.substring(i, i + 3))) {
                            op = exp.substring(i, i + 3);
                            i++;
                        } else {
                            op = exp.substring(i, i + 2);
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }

                switch (op) {
                    case "(":
                        operator.push(op);
                        break;
                    case ")":
                        while (!operator.peek().equals("("))
                            reversePolish.push(operator.pop());
                        operator.pop();
                        break;
                    case "~":
                    case ">>":
                        if (operator.peek().equals("("))
                            operator.push(op);
                        else {
                            while (!operator.peek().equals("#") && !operator.peek().equals("&") &&
                                    !operator.peek().equals("|") && !operator.peek().equals("^") && !operator.peek().equals("("))
                                reversePolish.push(operator.pop());
                            operator.push(op);
                        }
                        break;
                    case "<<":
                        if (operator.peek().equals("("))
                            operator.push(op);
                        else {
                            while (!operator.peek().equals("#") && !operator.peek().equals("&") &&
                                    !operator.peek().equals("|") && !operator.peek().equals("^") && !operator.peek().equals("("))
                                reversePolish.push(operator.pop());
                            operator.push(op);
                        }
                        break;
                    case ">>>":
                    case "^":
                    case "|":
                    case "&":
                        if (operator.peek().equals("("))
                            operator.push(op);
                        else {
                            while (!operator.peek().equals("#") && !operator.peek().equals("&") &&
                                    !operator.peek().equals("|") && !operator.peek().equals("^") && !operator.peek().equals("("))
                                reversePolish.push(operator.pop());
                            operator.push(op);
                        }
                        break;
                }
                i++;
            }
        }
        while (!operator.peek().equals("#"))
            reversePolish.push(operator.pop());
        while (!reversePolish.isEmpty())
            res = res.length() == 0 ? reversePolish.pop() + res : reversePolish.pop() + " " + res;
        return res;
    }

    public static boolean isOperator(String c) {
        return c.equals("~") || c.equals("&") || c.equals("|") || c.equals("^") || c.equals(">>") || c.equals("<<")
                || c.equals(">>>") || c.equals("(") || c.equals(")");
    }

    public boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }
}
