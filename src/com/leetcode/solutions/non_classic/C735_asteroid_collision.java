package com.leetcode.solutions.non_classic;

import java.util.LinkedList;

public class C735_asteroid_collision {

    public int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
                s.add(a[i]);
            else if (s.getLast() <= -a[i]) // if collision and a[i] will destroy the one in stack, pollLast() will poll the top of stack out
                if (s.pollLast() < -a[i]) i--; // i-- so that a[i] keep the same next round, since a[i] potentially can destroy more from stack
            // if collision and top of stack will destroy a[i], simply continue, and stack remain the same
        }
        return s.stream().mapToInt(i->i).toArray();
    }

    /*
    Solution 2, easier to understand
     */
    public int[] asteroidCollision_2(int[] a) {
        LinkedList<Integer> s = new LinkedList<>();
        for (int i : a) {
            if (i > 0)
                s.add(i);
            else {
                while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                    s.pollLast();
                if (!s.isEmpty() && s.getLast() == -i)
                    s.pollLast();
                else if (s.isEmpty() || s.getLast() < 0)
                    s.add(i);
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }
}
