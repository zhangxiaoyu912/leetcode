package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.Stack;

public class C224_basic_calculator {
    public int calculate(String s) {
        // delte white spaces
        s = s.replaceAll(" ", "");

        Stack<String> stack = new Stack<>();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;

            if (arr[i] >= '0' && arr[i] <= '9') {
                sb.append(arr[i]);

                if (i == arr.length - 1) {
                    stack.push(sb.toString());
                }
            } else {
                if (sb.length() > 0) {
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }

                if (arr[i] != ')') {
                    stack.push(new String(new char[] { arr[i] }));
                } else {
                    // when meet ')', pop and calculate
                    ArrayList<String> t = new ArrayList<String>();
                    while (!stack.isEmpty()) {
                        String top = stack.pop();
                        if (top.equals("(")) {
                            break;
                        } else {
                            t.add(0, top);
                        }
                    }

                    int temp = 0;
                    if (t.size() == 1) {
                        temp = Integer.valueOf(t.get(0));
                    } else {
                        for (int j = t.size() - 1; j > 0; j = j - 2) {
                            if (t.get(j - 1).equals("-")) {
                                temp += 0 - Integer.valueOf(t.get(j));
                            } else {
                                temp += Integer.valueOf(t.get(j));
                            }
                        }
                        temp += Integer.valueOf(t.get(0));
                    }
                    stack.push(String.valueOf(temp));
                }
            }
        }

        ArrayList<String> t = new ArrayList<String>();
        while (!stack.isEmpty()) {
            String elem = stack.pop();
            t.add(0, elem);
        }

        int temp = 0;
        for (int i = t.size() - 1; i > 0; i = i - 2) {
            if (t.get(i - 1).equals("-")) {
                temp += 0 - Integer.valueOf(t.get(i));
            } else {
                temp += Integer.valueOf(t.get(i));
            }
        }
        temp += Integer.valueOf(t.get(0));

        return temp;

        // my solution, works for 29/37 cases
//         if (s == null || s.length() == 0)
//             return 0;

//         Stack<String> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i ++) {
//             char c = s.charAt(i);
//             if (c == ' ') {
//                 continue;
//             } else if (c >= '0' && c <= '9') {
//                 String str = String.valueOf(c);
//                 if (i + 1 < s.length()) {
//                     i++;
//                     while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//                         str += s.charAt(i);
//                         i++;
//                     }
//                     i--;
//                 }
//                 int part = Integer.parseInt(str);
//                 if (stack.isEmpty())
//                     stack.push(part + "");
//                 else if (stack.peek().equals("+") || stack.peek().equals("-")) {
//                     String opt = stack.pop();
//                     int num = Integer.parseInt(stack.pop());
//                     if (opt.equals("+"))
//                         num += part;
//                     else if (opt.equals("-"))
//                         num -= part;
//                     stack.push(num + "");
//                 }
//             } else if (c == '+' || c == '-') {
//                 stack.push(c + "");
//             } else if (c == '(') {
//                 String sub = "";
//                 if (i + 1 < s.length()) {
//                     i++;
//                     while (i < s.length() && s.charAt(i) != ')') {
//                         sub += s.charAt(i);
//                         i++;
//                     }
//                     i--;
//                 }
//                 int part = calculate(sub);
//                 if (stack.isEmpty())
//                     stack.push(part + "");
//                 else if (stack.peek().equals("+") || stack.peek().equals("-")) {
//                     String opt = stack.pop();
//                     int num = Integer.parseInt(stack.pop());
//                     if (opt.equals("+"))
//                         num += part;
//                     else if (opt.equals("-"))
//                         num -= part;
//                     stack.push(num + "");
//                 }
//             }
//         }

//         return Integer.parseInt(stack.pop());
    }

    public static void main(String[] strings) {
        C224_basic_calculator c = new C224_basic_calculator();
        System.out.println(c.calculate("1 + (50 - 15) - 1"));
    }
}
