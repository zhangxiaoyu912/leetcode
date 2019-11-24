package com.leetcode.solutions.classic;

import java.util.*;

public class C853_car_fleet {

    /*
    Solution 1, has to use TreeMap to sort based on position, which is a trick, (input is not sorted based on position)
     */
    public int carFleet(int target, int[] pos, int[] speed) {
        TreeMap<Integer, Double> m = new TreeMap<>();
        for (int i = 0; i < pos.length; ++i) m.put(-pos[i], (double)(target - pos[i]) / speed[i]);
        int res = 0; double cur = 0;
        for (double time : m.values()) {
            if (time > cur) {
                cur = time;
                res++;
            }
        }
        return res;
    }

    /*
    Solution, this is wrong since the original input position is not sorted !!
     */
    public int carFleet_2(int target, int[] position, int[] speed) {
        int res = 0;
        int idx = 0;
        double cur = 0;
        for (int i = 0; i < position.length; ++i) {
            double time = (target - position[i]) / speed[i];
            if (time > cur) {
                cur = time;
                res ++;
            }
        }

        return res;
    }


}
