package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C49_group_anagrams {

    /*
    Solution 1: neat code ! notice the map opt doesn't check key
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);// fixme: this works
        }
        return new ArrayList<List<String>>(map.values());
    }

    /*
    Solution 2: long and lots to learn from the solution 1:
        map checking contains the key or not can be shorter
     */
    public List<List<String>> groupAnagrams_ori(String[] strs) {
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
        C49_group_anagrams c = new C49_group_anagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(c.groupAnagrams(strs));
    }
}
