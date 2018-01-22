package com.leetcode.solutions.classic;

import java.util.HashMap;

public class C13_roman_to_integer {
    public int romanToInt(String s) {
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        dict.put('I',1);
        dict.put('V',5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);

        int res = 0;

        int i = 0;

        for (i = 0; i < s.length()-1; i++){
            if (dict.get(s.charAt(i)) >= dict.get(s.charAt(i+1))){
                res += dict.get(s.charAt(i));
            }else{
                res -= dict.get(s.charAt(i));
            }
        }

        res += dict.get(s.charAt(i));
        return res;

    }
}
