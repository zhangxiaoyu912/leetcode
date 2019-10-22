package com.leetcode.solutions;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class C150 {

    // better solution online, process in order
    public static int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) { //push to stack if it is a number
                stack.push(t);
            } else {//pop numbers from stack if it is an operator
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }

//    public int evalRPN(String[] tokens) {
//        int length = tokens.length;
//
//        if (length == 1)
//            return Integer.parseInt(tokens[0]);
//
//        if (!isOpt(tokens[length - 1]))
//            throw new RuntimeException("the end must be opt");
//
//        String opt = tokens[length - 1];
//        int first = 0;
//        int second = 0;
//
//        if (!isOpt(tokens[length - 2])) {
//            second = Integer.parseInt(tokens[length - 2]);
//            String[] firstArray = new String[length - 2];
//            System.arraycopy(tokens, 0, firstArray, 0, length - 2);
//            first = evalRPN(firstArray);
//        } else {
//            int index = length - 2;
//            int measure = 0;
//            for (int i = length - 2; i >= 0; i --) {
//                if (isOpt(tokens[i]))
//                    measure += 2;
//                else
//                    measure -= 1;
//                index --;
//
//                if (measure == 0) {
//                    index ++;
//                    String[] firstArray = new String[index];
//                    String[] secArray = new String[length - 1 - index];
//                    System.arraycopy(tokens, index, secArray, 0, length - 1 - index);
//                    System.arraycopy(tokens, 0, firstArray, 0, index);
//
//                    first = evalRPN(firstArray);
//                    second = evalRPN(secArray);
//                    break;
//                }
//            }
//        }
//
//        if (opt.equals("*"))
//            return first * second;
//        else if (opt.equals("/")) {
//            return first / second;
//        } else if (opt.equals("+"))
//            return first + second;
//        else //if (opt.equals("-"))
//            return first - second;
//    }
//
//    private boolean isOpt(String str) {
//        return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-");
//    }

    public static void main(String[] args) {
        String[] str = new String[]{"4","-2","/","2","-3","-","-"};//{"4", "13", "5", "/", "+"};//{"2", "1", "+", "3", "*"};
        C150 c = new C150();
        int result = c.evalRPN(str);
        System.out.println(result);
    }
}
