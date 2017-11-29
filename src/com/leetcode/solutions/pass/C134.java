package com.leetcode.solutions.pass;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class C134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = -1;
        int length = gas.length;
        if (length == 0)
            return index;
        if (length != cost.length)
            return index;

        for (int i = 0; i < length; i ++) {
            int step = 0;
            int pos = i;
            int vol = 0;
            while (step < length) {
                pos = i + step < length ? i + step : (i + step) % length;
                vol = vol + gas[pos] - cost[pos];
                if (vol < 0)
                    break;
                step += 1;
            }
            if (step == length) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] strings) {
        C134 c = new C134();
        int[] gas = new int[]{2, 10, 1};
        int[] cost = new int[]{3, 4, 2};
        int index = c.canCompleteCircuit(gas, cost);
        System.out.print(index);
    }
}
