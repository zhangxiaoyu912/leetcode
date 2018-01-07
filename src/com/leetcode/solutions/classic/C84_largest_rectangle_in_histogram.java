package com.leetcode.solutions.classic;

import java.util.Stack;

public class C84_largest_rectangle_in_histogram {
    /*
    https://aaronice.gitbooks.io/lintcode/content/data_structure/largest_rectangle_in_histogram.html

    We process the elements in left-to-right order and maintain a stack of information about started but yet unfinished subhistograms. Whenever a new element arrives it is subjected to the following rules. If the stack is empty we open a new subproblem by pushing the element onto the stack. Otherwise we compare it to the element on top of the stack. If the new one is greater we again push it. If the new one is equal we skip it. In all these cases, we continue with the next new element. If the new one is less, we finish the topmost subproblem by updating the maximum area w.r.t. the element at the top of the stack. Then, we discard the element at the top, and repeat the procedure keeping the current new element. This way, all subproblems are finished until the stack becomes empty, or its top element is less than or equal to the new element, leading to the actions described above. If all elements have been processed, and the stack is not yet empty, we finish the remaining subproblems by updating the maximum area w.r.t. to the elements at the top. For the update w.r.t. an element, we find the largest rectangle that includes that element. Observe that an update of the maximum area is carried out for all elements except for those skipped. If an element is skipped, however, it has the same largest rectangle as the element on top of the stack at that time that will be updated later. The height of the largest rectangle is, of course, the value of the element. At the time of the update, we know how far the largest rectangle extends to the right of the element, because then, for the first time, a new element with smaller height arrived. The information, how far the largest rectangle extends to the left of the element, is available if we store it on the stack, too. We therefore revise the procedure described above. If a new element is pushed immediately, either because the stack is empty or it is greater than the top element of the stack, the largest rectangle containing it extends to the left no farther than the current element. If it is pushed after several elements have been popped off the stack, because it is less than these elements, the largest rectangle containing it extends to the left as far as that of the most recently popped element. Every element is pushed and popped at most once and in every step of the procedure at least one element is pushed or popped. Since the amount of work for the decisions and the update is constant, the complexity of the algorithm is O(n) by amortized analysis.
    */

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            // current = -1 as i reach the last, this way it will process all the remaining element in the stack in the end
            int current = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && current <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
}
