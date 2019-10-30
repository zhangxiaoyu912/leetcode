package com.leetcode.solutions.classic;

import java.util.*;

public class C609_Find_Duplicate_File_in_System {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<List<String>>();// fixme: List<List...> interface by ArrayList<List.....
        int n = paths.length;
        if (n == 0) return result;

        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] strs = path.split("\\s+");
            for (int i = 1; i < strs.length; i++) {
                int idx = strs[i].indexOf("(");
                String content = strs[i].substring(idx);
                String filename = strs[0] + "/" + strs[i].substring(0, idx);
                Set<String> filenames = map.getOrDefault(content, new HashSet<String>());// fixme: using getOrDefault to avoid check contains
                filenames.add(filename);
                map.put(content, filenames);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                result.add(new ArrayList<String>(map.get(key)));// fixme: from set to list, from array to list a tricky a little bit
            }
        }

        return result;
    }
}
