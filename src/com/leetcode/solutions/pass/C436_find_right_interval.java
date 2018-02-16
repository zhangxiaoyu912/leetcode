package com.leetcode.solutions.pass;

import java.util.Map;
import java.util.TreeMap;

public class C436_find_right_interval {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        if (intervals == null || intervals.length < 2)
            return new int[]{-1};

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i ++)
            map.put(intervals[i].start, i);

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i ++) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            res[i] = (entry != null) ? entry.getValue() : -1;
        }

        return res;
    }
}
