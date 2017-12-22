package com.leetcode.solutions.discussions;

import java.util.Stack;

public class C150_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        int returnValue = 0;

        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;

//         if (tokens.length == 1)
//             return Integer.parseInt(tokens[0]);

//         Stack<String> opts = new Stack<>();
//         Stack<String> nums = new Stack<>();
//         int flag = 0;
//         for (int i = tokens.length - 1; i >= 0; i --) {
//             String str = tokens[i];
//             if (isOpt(str)) {
//                 opts.push(str);
//                 flag = 0;
//             } else {
//                 nums.push(str);
//                 flag ++;
//             }

//             if (flag == 2 && !opts.isEmpty() && nums.size() >= 2) {
//                 int num1 = Integer.parseInt(nums.pop());
//                 int num2 = Integer.parseInt(nums.pop());
//                 String opt = opts.pop();
//                 int num = optNum(num1, num2, opt);
//                 nums.push(String.valueOf(num));
//                 flag = 1;
//             }
//         }

//         if (nums.size() == 1)
//             return Integer.parseInt(nums.pop());
//         else {
//             int num1 = Integer.parseInt(nums.pop());
//             int num2 = Integer.parseInt(nums.pop());
//             String opt = opts.pop();
//             return optNum(num1, num2, opt);
//         }
    }

//     private int optNum(int num1, int num2, String opt) {
//         if (opt.equals("*"))
//             return num1 * num2;
//         else if (opt.equals("/"))
//             return num1 / num2;
//         else if (opt.equals("+"))
//             return num1 + num2;
//         else
//             return num1 - num2;
//     }

//     private boolean isOpt(String str) {
//         return str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-");
//     }
}
