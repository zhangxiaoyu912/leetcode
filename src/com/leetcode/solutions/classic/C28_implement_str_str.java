package com.leetcode.solutions.classic;

public class C28_implement_str_str {
    public int strStr(String haystack, String needle) {
        // the most neat version
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }

        // the working version
//         if(haystack==null || needle==null)
//             return 0;

//         if(needle.length() == 0)
//             return 0;

//         for(int i=0; i<haystack.length(); i++){
//             // bail out even ealier before reach haystack.length()
//             if(i + needle.length() > haystack.length())
//                 return -1;

//             int m = i;
//             for(int j=0; j<needle.length(); j++){
//                 if(needle.charAt(j)==haystack.charAt(m)){
//                     if(j==needle.length()-1)
//                         return i;
//                     m++;
//                 }else{
//                     break;
//                 }

//             }
//         }

//         return -1;

        // partically work version and fail test case of "mississippi", "issip"
//         if (haystack == null && needle == null)
//             return 0;
//         else if (haystack.length() == 0 && needle.length() == 0)
//             return 0;
//         else if (haystack == null || needle == null)
//             return -1;
//         else if (needle.length() == 0)
//             return 0;
//         else if (haystack.length() == 0)
//             return -1;

//         int j = 0;
//         for (int i = 0; i < haystack.length(); i ++) {
//             if (haystack.charAt(i) != needle.charAt(j)) {
//                 j = 0;
//             } else {
//                 if (j == needle.length() - 1)
//                     return i - j;
//                 j ++;
//             }
//         }

//         return -1;
    }

    public static void main(String[] strings) {
        C28_implement_str_str c = new C28_implement_str_str();
        // this test case is very tricky as "issip" because "issis" and "issip" intersected and match need to happen
        c.strStr("mississippi", "issip");
    }
}
