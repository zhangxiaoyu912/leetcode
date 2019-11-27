package com.leetcode.solutions.non_classic;

import java.util.*;

public class C857_minimum_cost_to_hire_k_workers {

    /**
     * "1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group."
     * So for any two workers in the paid group,
     * we have wage[i] : wage[j] = quality[i] : quality[j]
     * So we have wage[i] : quality[i] = wage[j] : quality[j]
     * We pay wage to every worker in the group with the same ratio compared to his own quality.
     *
     * "2. Every worker in the paid group must be paid at least their minimum wage expectation."
     * For every worker, he has an expected ratio of wage compared to his quality.
     *
     * So to minimize the total wage, we want a small ratio.
     * So we sort all workers with their expected ratio, and pick up K first worker.
     * Now we have a minimum possible ratio for K worker and we their total quality.
     *
     * As we pick up next worker with bigger ratio, we increase the ratio for whole group.
     * Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
     * We calculate the current ratio * total quality = total wage for this group.
     *
     * We redo the process and we can find the minimum total wage.
     * Because workers are sorted by ratio of wage/quality.
     * For every ratio, we find the minimum possible total quality of K workers.
     *
     * fixme: so want to choose the lowest quality workers, but use the chosen ones' highest pay ratio pay to pay everyone
     *
     */

    // fixme: PriorityQueue time complexity for offer() and poll() is O(logn), time complexity for peek() is O(1)
    static public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        //smallest ratio first, so we can make sure that we don't violate the minimum expectation rule
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // use a priority queue to remove the largest quality, sorted with the largest quality ahead
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        // fixme: for using PriorityQueue to get top K element, we can just loop once like below instead of loop once to insert everything, then pop top k
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();// remove the one with highest quality to minimize the cost
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);// works[0] will only increase, so use this ratio to pay everyone, it's fair for existing chosen ones
        }
        return res;
    }

    public static void main(String[] strings) {
        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
    }
}
