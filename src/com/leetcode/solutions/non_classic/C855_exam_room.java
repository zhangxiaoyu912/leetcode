package com.leetcode.solutions.non_classic;

import java.util.*;

public class C855_exam_room {
    class ExamRoom {
        PriorityQueue<Interval> pq;
        int N;

        // fixme: the x = -1, and y = N present if first and last seat's people leave the seat, the internal still meaningful
        class Interval {
            int x, y, dist;
            public Interval(int x, int y) {
                this.x = x;
                this.y = y;
                if (x == -1) {
                    this.dist = y;
                } else if (y == N) {
                    this.dist = N - 1 - x;
                } else {
                    this.dist = Math.abs(x - y) / 2;
                }
            }
        }

        public ExamRoom(int N) {
            // fixme: the comparator of priority queue: dist first, otherwise, seat in the lowest index seat, which is required
            this.pq = new PriorityQueue<>((a, b) -> a.dist != b.dist? b.dist - a.dist : a.x - b.x);
            this.N = N;
            pq.add(new Interval(-1, N));
        }

        // fixme: there are other solutions as well, talk about the trade off of this solution, seat() faster as O(logn) but leave slow as O(n)
        // O(logn): poll top candidate, split into two new intervals
        public int seat() {
            int seat = 0;
            Interval interval = pq.poll();
            if (interval.x == -1) seat = 0;
            else if (interval.y == N) seat = N - 1;
            else seat = (interval.x + interval.y) / 2;

            pq.offer(new Interval(interval.x, seat));
            pq.offer(new Interval(seat, interval.y));

            return seat;
        }

        // O(n)Find head and tail based on p. Delete and merge two ends
        public void leave(int p) {
            Interval head = null, tail = null;
            // fixme: how to iterate the priority queue with care about the priority
            List<Interval> intervals = new ArrayList<>(pq);
            for (Interval interval : intervals) {
                if (interval.x == p) tail = interval;
                if (interval.y == p) head = interval;
                if (head != null && tail != null) break;
            }
            // Delete
            pq.remove(head);
            pq.remove(tail);
            // Merge
            pq.offer(new Interval(head.x, tail.y));
        }
    }
}
