package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C56 {
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

    // in lots of cases, sort it first will make the problem much easier to resolve !!
    // The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals.
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start)
                    return o1.start - o2.start;
                else
                    return o1.end - o2.end;
            }
        });

        Interval prev = intervals.get(0);
        // if no overlap, add prev into the list
        // if overlap, merge and update prev
        for (int i = 1; i < intervals.size(); i ++) {
            if (prev.end < intervals.get(i).start) {
                result.add(prev);
                prev = intervals.get(i);
            } else {
                prev = new Interval(prev.start, Math.max(prev.end, intervals.get(i).end));
            }
        }
        result.add(prev);

        return result;
    }
}
