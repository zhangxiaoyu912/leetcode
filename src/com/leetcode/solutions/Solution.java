package com.leetcode.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
        public static void main(String[] strs) {
            Solution sol = new Solution();
            List<String> list = new ArrayList<>();
            list.add("1,28,300.1,San Francisco");
            list.add("1,7,208.1,San Francisco");
            list.add("4,5,209.1,San Francisco");
//            list.add("4,8,207.1,San Francisco");

            List<String> res = sol.rankList(list);
            System.out.println(res);
        }

        int PS = 2;
        public List<String> rankList(List<String> stream) {
            if (stream == null || stream.size() < PS)
                return stream;

            Queue<String> queueBack = new ArrayDeque<>();
            Queue<String> queueCurr = new ArrayDeque<>();
            Set<String> set = new HashSet<>();
            List<String> res = new ArrayList<>();
            List<String> page = new ArrayList<>();

            int i = 0;
            while (i < stream.size()) {
                if (page.size() <= PS && i < stream.size()) {
                    String str;
                    if (!queueBack.isEmpty()) {
                        str = queueBack.poll();
                    } else {
                        str = stream.get(i);
                        i ++;
                    }
                    String host = str.split(",")[0];
                    if (!set.contains(host)) {
                        set.add(host);
                        page.add(str);
                    } else {
                        queueCurr.add(str);
                    }
                } else {
                    // to process if identical host < available page size
                    while (!queueCurr.isEmpty()) {
                        String str1 = queueCurr.poll();
                        page.add(str1);
                    }
                }

                if (page.size() == PS) {
                    List<String> tempL = new ArrayList<>(page);
                    res.addAll(tempL);
                    page.clear();
                    set.clear();

                    // simply just swap each time without inspecting the content
                    Queue<String> tempQ = queueBack;
                    queueBack = queueCurr;
                    queueCurr = tempQ;
                }
            }

            // process all backlog
            res.addAll(page);
            while (!queueBack.isEmpty())
                res.add(queueBack.poll());
            while (!queueCurr.isEmpty())
                res.add(queueCurr.poll());

            return res;
        }


    }
