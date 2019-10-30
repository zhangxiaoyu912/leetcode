package com.leetcode.solutions.classic;

import java.util.*;

public class C155_min_stack {

    /*
    fixme: it says min stack, doesn't say pop() will return min, getMin() return min
     */
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            int peek = stack.pop();
            if (peek == min){
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
