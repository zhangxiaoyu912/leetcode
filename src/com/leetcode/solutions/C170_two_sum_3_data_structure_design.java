package com.leetcode.solutions;

import java.util.HashMap;

public class C170_two_sum_3_data_structure_design {

    // solution use just a map to store all number and its occur number
    static public class TwoSum {
        private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

        public void add(int number) {
            if (elements.containsKey(number)) {
                elements.put(number, elements.get(number) + 1);
            } else {
                elements.put(number, 1);
            }
        }

        public boolean find(int value) {
            for (Integer i : elements.keySet()) {
                int target = value - i;
                if (elements.containsKey(target)) {
                    if (i == target && elements.get(target) < 2) {
                        continue;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    // using a list to store doesn't work and not efficient
//    static class TwoSum {
//
//        List<Integer> list = new LinkedList<>();
//
//        /** Initialize your data structure here. */
//        public TwoSum() {
//
//        }
//
//        /** Add the number to an internal data structure.. */
//        public void add(int number) {
//            if (list.size() == 0) {
//                list.add(number);
//                return;
//            }
//
//            for (int i = 0; i < list.size(); i ++) {
//                if (list.get(i) > number) {
//                    if (i == 0)
//                        list.add(0, number);
//                    else
//                        list.add(i - 1, number);
//                    return;
//                }
//            }
//
//            list.add(number);
//        }
//
//        /** Find if there exists any pair of numbers which sum is equal to the value. */
//        public boolean find(int value) {
//            if (list.size() < 2)
//                return false;
//
//            int b = 0;
//            int e = list.size() - 1;
//            while (b < e) {
//                int num = list.get(b) + list.get(e);
//                if (num == value)
//                    return true;
//                else if (num > value)
//                    e --;
//                else
//                    b ++;
//            }
//
//            return false;
//        }
//    }

    public static void main(String[] strings) {
        C170_two_sum_3_data_structure_design.TwoSum c = new C170_two_sum_3_data_structure_design.TwoSum();
        c.add(1);
        c.add(-1);
        System.out.println(c.find(0));
    }
}
