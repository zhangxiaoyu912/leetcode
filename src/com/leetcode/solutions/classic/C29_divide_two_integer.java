package com.leetcode.solutions.classic;

public class C29_divide_two_integer {

    /**
     * math problem with input as int, think whether need to convert to long in the computation
     */
    public int divide(int dividend, int divisor) {
        //handle special cases
        if(divisor==0) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int result = 0;
        while(pDividend>=pDivisor){
            //calculate number of left shifts
            int numShift = 0;
            // using shift to replace multiply !!!
            while(pDividend>=(pDivisor<<numShift)){
                numShift++;
            }

            //dividend minus the largest shifted divisor
            result += 1<<(numShift-1);
            pDividend -= (pDivisor<<(numShift-1));
        }

        // clear condition !
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            return result;
        }else{
            return -result;
        }

        // my code, work for a few cases
//         if (dividend == 0 || divisor == 0)
//             return 0;

//         long divid = Math.abs((long)dividend);
//         long divis = Math.abs((long)divisor);

//         boolean positive = (divid * divis > 0);
//         // might not be needed
//         if (positive && (divid < divis))
//             return 0;

//         long res = 1;
//         long pro = divis;
//         while (pro < divid) {
//             int m = divide((int)divid, (int) (pro + pro));
//             if (m > 0) {
//                 pro += pro;
//                 res += res;
//             } else {
//                 pro += divis;
//                 res ++;
//             }
//         }

// //        if (res > 1)
// //            res --;

//         if (!positive)
//             res *= -1;

//         if (res > (long) Integer.MAX_VALUE)
//             res = (long) Integer.MAX_VALUE;

//         return (int) res;
    }

    public static void main(String[] strings) {
        C29_divide_two_integer c = new C29_divide_two_integer();
        System.out.println(c.divide(-2147483648, -1));
    }
}
