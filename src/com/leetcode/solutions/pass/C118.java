package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

 For example, given numRows = 5,
 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */

public class C118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0)
            return list;

        List<Integer> seed = new ArrayList<>();
        seed.add(1);
        list.add(seed);

        for (int i = 1; i < numRows; i ++) {
            List<Integer> level = new ArrayList<>(seed.size() + 1);
            level.add(1);
            for (int j = 0; j < seed.size() - 1; j ++)
                level.add(seed.get(j) + seed.get(j + 1));
            level.add(1);
            list.add(level);
            seed = level;
        }

        return list;
    }

    public static void main(String[] strings) {
        C118 c = new C118();
        List<List<Integer>> list = c.generate(5);
        for (List<Integer> level : list) {
            System.out.println("=========");
            for (int num : level)
                System.out.println(num);
        }
    }
}
