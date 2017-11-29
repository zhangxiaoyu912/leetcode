package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */

public class C119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        if (rowIndex == 0)
            return list;

        for (int i = 1; i < rowIndex + 1; i ++) {
            List<Integer> level = new ArrayList<>(list.size() + 1);
            level.add(1);
            for (int j = 0; j < list.size() - 1; j ++)
                level.add(list.get(j) + list.get(j + 1));
            level.add(1);
            list = level;
        }

        return list;
    }

    public static void main(String[] strings) {
        C119 c = new C119();
        List<Integer> list = c.getRow(3);
        for (int num : list)
            System.out.println(num);
    }
}
