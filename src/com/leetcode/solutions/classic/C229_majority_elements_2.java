package com.leetcode.solutions.classic;

import java.util.ArrayList;
import java.util.List;

public class C229_majority_elements_2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        // the trick of using Integer instead of int so that can present the 'untaken slot'
        Integer n1=null, n2=null;
        int c1=0, c2=0;

        // if value in c1 or c2, add counter; otherwise cancle other existing numbers's count
        for(int i: nums){
            if(n1!=null && i==n1.intValue()){
                c1++;
            }else if(n2!=null && i==n2.intValue()){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }

        // for tie breaker, like 1 2 3 1 2 3 3 5, decide 3 and 5 who is the most
        // tie case only apply to frequency > n/3 and the n/3 - 1
        c1=c2=0;

        for(int i: nums){
            if(i==n1.intValue()){
                c1++;
            }else if(i==n2.intValue()){
                c2++;
            }
        }

        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);

        return result;
    }
}
