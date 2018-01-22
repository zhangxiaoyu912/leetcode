package com.leetcode.solutions.pass;

public class C7_reverse_int {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            rev = rev*10 + x%10;
            x = x/10;
        }

        return rev;
    }

    public static void main(String[] strings) {
        C7_reverse_int c = new C7_reverse_int();
        c.reverse(-2147483648);
    }
}
