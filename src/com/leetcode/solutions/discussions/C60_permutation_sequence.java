package com.leetcode.solutions.discussions;

import java.util.ArrayList;

public class C60_permutation_sequence {
    public String getPermutation(int n, int k) {
        // initialize all numbers
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }

        // change k to be index
        k--;

        // set factorial of n
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod = mod * i;
        }

        String result = "";

        // find sequence
        for (int i = 0; i < n; i++) {
            // mod always decrease by (n - 1)
            mod = mod / (n - i);
            // find the right number(curIndex) of the element to insert to
            int curIndex = k / mod;
            // update k
            k = k % mod;

            // get number according to curIndex
            result += numberList.get(curIndex);
            // remove from list
            // using ArrayList hence that remove doesn't change other ele's index by delete this one
            numberList.remove(curIndex);
        }

        return result.toString();
    }
}
