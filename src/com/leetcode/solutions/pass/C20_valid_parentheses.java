package com.leetcode.solutions.pass;

import java.util.Stack;

public class C20_valid_parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
