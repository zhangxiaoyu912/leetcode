package com.leetcode.solutions.classic;

import java.util.HashMap;

public class C205_isomorphic_strings {

    /*
    Solution 1, fixme: the neat code
     */
    public boolean isIsomorphic (String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    /*
    Solution 2, fixme: using the hashmap, it is traditional
     */
    public boolean isIsomorphic_2(String s, String t) {
        if (s == null && t == null)
            return true;

        if (s.length() != t.length())
            return false;

        // using containsValue + the neat coding + else block is very neat as well
        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(map.containsKey(c1)){
                if(map.get(c1)!=c2)// if not consistant with previous ones
                    return false;
            }else{
                if(map.containsValue(c2)) //if c2 is already being mapped
                    return false;
                map.put(c1, c2);
            }
        }

        // my solution, also works, but usingn two maps
//         Map<Character, Character> mapS = new HashMap<>();
//         Map<Character, Character> mapT = new HashMap<>();
//         for (int i = 0; i < t.length(); i ++) {
//             char cS = s.charAt(i);
//             char cT = t.charAt(i);
//             if (!mapS.containsKey(cS)) {
//                 mapS.put(cS, cT);
//             } else {
//                 if (mapS.get(cS) != cT)
//                     return false;
//             }

//             if (!mapT.containsKey(cT)) {
//                 mapT.put(cT, cS);
//             } else {
//                 if (mapT.get(cT) != cS)
//                     return false;
//             }
//         }

        return true;
    }
}
