package com.leetcode.solutions.discussions;

import java.util.*;

public class C253_meeting_room_2 {

    /*
    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
    find the minimum number of conference rooms required.
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));// fixme: Java8 style comparator

        PriorityQueue<Integer> heap = new PriorityQueue<>();// fixme: a mini heap
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                // fixme: the entry in heap presents each meeting room and its latest time becoming available
                if (itv[0] >= heap.peek()) {// fixme: if no overlap, for this meeting room, update its latest availability
                    heap.poll();
                } else {
                    count++;// fixme: if overlap, add meeting room number
                }

                heap.offer(itv[1]);
            }
        }

        return count;
    }
}
