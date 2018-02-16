package com.leetcode.solutions.classic;

public class C38_count_and_say {

    // this problem itself is very subtle,
    // hence working on other code doesn't much help understand the problem or the code
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    public static void main(String[] strings) {
        C38_count_and_say c = new C38_count_and_say();
        c.countAndSay(4);
    }
}
