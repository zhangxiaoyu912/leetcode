package com.leetcode.solutions.classic;

public class C158_read_n_character_given_read4_2 {
//    public class Solution extends Reader4 {
//        /**
//         * @param buf Destination buffer
//         * @param n   Maximum number of characters to read
//         * @return    The number of characters read
//         */
//
//        // http://blog.csdn.net/fantasiasango/article/details/52669281
//
//    变化是这样：比如先call了n=3，然后call n=5，那么第一次就读入了4个char，
//    第二次call应该把上一次的最后一个char拿来。也就是说要有个cache取缓存已读取的字符，
//    然后从这个cache里面取。每次读4个字符，放入 cache，然后
//            in = Math.min(n - total, buff.size()) 这个是精髓，这样就知道还需要多少个字符了
//        LinkedList<Character> buff = new LinkedList<Character>();
//
//        public int read(char[] buf, int n) {
//            int total = 0;
//            while(true){
//                char[] temp = new char[4];
//                int in = read4(temp);
//                for(int i = 0; i < in; i++) buff.add(temp[i]);
//
//                // 判断还需要写入多少个到结果， 比如读了4个，但是只要3个；或者要4个，只有3个了。
//                in = Math.min(n - total, buff.size());
//
//                for(int i = 0; i < in; i++) buf[total++] = buff.poll();
//                if(in == 0) break;
//            }
//            return total;
//        }
//    }
}
