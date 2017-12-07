package com.leetcode.solutions.pass;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 */
public class C134 {

    // a better solution based on facts below, (2) is tricky
    // 1) if the sum of gas >= the sum of cost, then the circle can be completed.
    // 2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.
    // explain for (2)
    // If gas[A] < cost[A], then A can not even reach B.
//    So to reach C from A, gas[A] must >= cost[A].
//    Given that A can not reach C, we have gas[A] + gas[B] < cost[A] + cost[B],
//    and gas[A] >= cost[A],
//    Therefore, gas[B] < cost[B], i.e., B can not reach C.
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining = 0; // track current remaining
        int total = 0; // track total remaining
        int start = 0;

        // the nice thing is it only loop once
        for (int i = 0; i < gas.length; i++) {
            int remaining = gas[i] - cost[i];

            //if sum remaining of (i-1) >= 0, continue
            if (sumRemaining >= 0) {
                sumRemaining += remaining;
                //otherwise, reset start index to be current
            } else {
                sumRemaining = remaining;
                start = i;
            }
            total += remaining;
        }

        if (total >= 0){
            return start;
        }else{
            return -1;
        }
    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int index = -1;
//        int length = gas.length;
//        if (length == 0)
//            return index;
//        if (length != cost.length)
//            return index;
//
//        for (int i = 0; i < length; i ++) {
//            int step = 0;
//            int pos = i;
//            int vol = 0;
//            while (step < length) {
//                pos = i + step < length ? i + step : (i + step) % length;
//                vol = vol + gas[pos] - cost[pos];
//                if (vol < 0)
//                    break;
//                step += 1;
//            }
//            if (step == length) {
//                index = i;
//                break;
//            }
//        }
//
//        return index;
//    }

    public static void main(String[] strings) {
        C134 c = new C134();
        int[] gas = new int[]{2, 10, 1};
        int[] cost = new int[]{3, 4, 2};
        int index = c.canCompleteCircuit(gas, cost);
        System.out.print(index);
    }
}
