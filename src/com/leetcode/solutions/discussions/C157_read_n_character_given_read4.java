package com.leetcode.solutions.discussions;

public class C157_read_n_character_given_read4 {
//    public class Solution extends Reader4 {
//        /**
//         * @param buf Destination buffer
//         * @param n   Maximum number of characters to read
//         * @return    The number of characters read
//         */
//        // https://segmentfault.com/a/1190000003794420
//        public int read(char[] buf, int n) {
//            for(int i = 0; i < n; i += 4){
//                char[] tmp = new char[4];
//                // 将数据读入临时数组
//                int len = read4(tmp);
//                // 将临时数组拷贝至buf数组，这里拷贝的长度是本次读到的个数和剩余所需个数中较小的
//                System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
//                // 如果读不满4个，说明已经读完了，返回总所需长度和目前已经读到的长度的较小的
//                if(len < 4) return Math.min(i + len, n);
//            }
//            // 如果循环内没有返回，说明读取的字符是4的倍数
//            return n;
//        }
//    }
}
