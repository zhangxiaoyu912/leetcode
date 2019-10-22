package com.leetcode.solutions.discussions;

import java.util.ArrayList;
import java.util.List;

public class C131_palindrome_partitioning {

    // the DP solution is available in https://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/
    // the DP solution also have Time O(n^2) Space O(n^2)


    // the 2nd solution, better than 3rd, utilize DP
    List<List<String>> results;
    boolean[][] isPalindrome;

    public List<List<String>> partition(String s) {
        results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        // scan firstly to mark all palindrome
        getIsPalindrome(s);

        // store all palindrome into list
        helper(s, 0, new ArrayList<Integer>());

        return results;
    }

    private void getIsPalindrome(String s) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        // the isPalindrome[i + 1][j - 1] will be marked before isPalindrome[i][j]
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    private void helper(String s,
                        int startIndex,
                        List<Integer> partition) {
        if (startIndex == s.length()) {
            addResult(s, partition);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // this make sure the all 'startIndex' and 'i' combination is a valid palindrome range
            if (!isPalindrome[startIndex][i]) {
                continue;
            }
            partition.add(i);
            helper(s, i + 1, partition);
            partition.remove(partition.size() - 1);
        }
    }

    private void addResult(String s, List<Integer> partition) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < partition.size(); i++) {
            result.add(s.substring(startIndex, partition.get(i) + 1));
            startIndex = partition.get(i) + 1;
        }
        results.add(result);
    }

    // 3rd solution : the typical recursive call structure, and this way it try all possible combinations
//    public List<List<String>> partition(String s) {
//        List<List<String>> lists = new ArrayList<>();
//        if (s == null || s.length() == 0)
//            return lists;
//
//        List<String> par = new ArrayList<>();
//        addPartition(s, 0, par, lists);
//        return lists;
//    }
//
//    private void addPartition(String s, int start, List<String> par, List<List<String>> lists) {
//        if (start == s.length()) {
//            List<String> temp = new ArrayList<>(par);
//            lists.add(temp);
//            return;
//        }
//
//        for (int i = start + 1; i <= s.length(); i ++) {
//            String subStr = s.substring(start, i);
//            if (isPalindrome(subStr)) {
//                par.add(subStr);
//                addPartition(s, i, par, lists);
//                par.remove(par.size() - 1);
//            }
//        }
//    }
//
//    private boolean isPalindrome(String s) {
//        int b = 0;
//        int e = s.length() - 1;
//        while (b < e) {
//            if (s.charAt(b) == s.charAt(e)) {
//                b += 1;
//                e -= 1;
//            } else {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] strings) {
        C131_palindrome_partitioning c = new C131_palindrome_partitioning();
        List<List<String>> lists = c.partition("cdd");
        for (List<String> list : lists) {
            System.out.println("==============");
            for (String str : list) {
                System.out.println(str + " ");
            }
        }
    }
}
