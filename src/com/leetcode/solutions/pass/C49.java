package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return result;

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
                map.put(key, list);
            }
        }

        for (Map.Entry entry : map.entrySet())
            result.add((List<String>) entry.getValue());

        return result;
    }

    public static void main(String[] strings) {
        C49 c = new C49();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(c.groupAnagrams(strs));
    }
}
