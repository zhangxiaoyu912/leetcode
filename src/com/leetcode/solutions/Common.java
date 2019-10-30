package com.leetcode.solutions;

import java.util.*;

// a place just for note some Java basic data structure common API
public class Common {

    public static void main(String[] args) {

        /**
         * Empty
         */
//        Collections.EMPTY_LIST; fixme: empty list

        /**
         * Array
         */
        char[][] temp = new char[5][]; // fixme: multi dimensions array only require length for first dimension
        char[] chars = Arrays.copyOf(temp[0], 5); // fixme: deep copy array content

        // java multi dimension array doesn't require same length
        String[][] arra = new String[5][];

        String[] array2 = {"1", "2"};
        System.out.println(array2.length); // fixme: String length has no (), array's length() has ()

        /**
         * List and ArrayList
         */
        List<List<String>> result = new ArrayList<List<String>>(); // fixme: List<List...> interface by ArrayList<List.....

        ArrayList<Integer> list = new ArrayList<Integer>(){{ add(1); add(2); }};

        ArrayList<ArrayList<Integer>> nested = new ArrayList<ArrayList<Integer>>(){{ add(list); }};// somehow this doesn't compile in hackerrank

        // fixme: deep copy, deep copy can be apply to hashmap as well, the same way (in constructor)
        List<Integer> current = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>(current);

        /**
         * Map and HashMap
         */
        //Set<String> filenames = map.getOrDefault(content, new HashSet<String>());// fixme: using getOrDefault to avoid check if...containsKey..else...

        Map<String, Integer> map1 = new HashMap<String, Integer>(){{ put("1", 1); }};

        HashMap<String, Integer> map2 = new HashMap<String, Integer>(){{ put("2", 2); }};

        Map<Integer, Map<String, Integer>> m1 = new HashMap<Integer, Map<String, Integer>>(){{ put(1, map1); }};

        Map<Integer, HashMap<String, Integer>> m2 = new HashMap<Integer, HashMap<String, Integer>>(){{ put(1, map2); }};

        HashMap<Integer, String[]> m3 = new HashMap<Integer, String[]>(){{ put(1, array2); }};

        m3.containsKey(1);

        /**
         * PriorityQueue
         */
        // priority queue, below is a min heap only
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.poll();
//        q.remove(o);

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));// fixme: priority queue comparator, here is using map's value to sort




        // Queue, use linkedlist to present
        LinkedList<Integer> queue1 = new LinkedList<Integer>();
        //queue1.push(1);// add to front, not a queue operation
        queue1.offer(1);// add element to to tail, fixme: it is generally preferable to use it than add
        queue1.poll();// pop the element
        queue1.peek();// read but not remove

        /**
         * String
         */
        String str = "aaa";
//        str.setCharAt(i, c); // modify the char

        /**
         * Character
         */
        Character.isDigit('5'); // fixme: tell if a char is digit

        Set<Integer> set = new HashSet<>();
//        set.contains()
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    StringBuilder sb = new StringBuilder();


    // when deal with tree problem, have to think if the problem can be resolved in recursive way, left || right, or left && right
}

