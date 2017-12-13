package com.leetcode.solutions.classic;

public class C168_excel_sheet_column_title {

    // for this type of problem, if left->right doesn't work, change direction
    public String convertToTitle(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("Input is not valid!");
        }

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }

        sb.reverse();
        return sb.toString();
    }
}
