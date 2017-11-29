package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

public class C60 {
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();

        return list.get(k - 1);
    }

    private void getPermutation(List<Integer> ints, List<Integer> reduced, int start, String str, List<String> list) {

    }

    public static void main(String[] strings) {
        C60 c = new C60();
        System.out.println(c.getPermutation(3, 6));
    }
}
