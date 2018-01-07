package com.leetcode.solutions.classic;

public class C50_power_x_n {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;

        // stack overflow
//         if(n==0)
//             return 1;

//         if(n<0){
//             return 1/myPow(x, -n);
//         }

//         double v = myPow(x, n/2);

//         if(n%2==0){
//            return v*v;
//         }else{
//            return v*v*x;
//         }
    }
}
