package com.leetcode.solutions.pass;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */

public class C165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i1 = 0;
        int i2 = 0;
        while(i1 < v1.length && i2 < v2.length) {
            int int1 = Integer.parseInt(v1[i1]);
            int int2 = Integer.parseInt(v2[i2]);

            if (int1 > int2)
                return 1;
            if (int1 < int2)
                return -1;
            else {
                i1 += 1;
                i2 += 1;
            }
        }

        if (i1 < v1.length) {
            while(i1 < v1.length) {
                if (Integer.parseInt(v1[i1]) == 0)
                    i1 += 1;
                else
                    break;
            }
        }

        if (i2 < v2.length) {
            while(i2 < v2.length) {
                if (Integer.parseInt(v2[i2]) == 0)
                    i2 += 1;
                else
                    break;
            }
        }

        if (v1.length == i1 && v2.length > i2)
            return -1;
        else if (v1.length > i1 && v2.length == i2)
            return 1;
        else
            return 0;

    }

    public static void main(String[] str) {
        C165 c = new C165();
        System.out.println(c.compareVersion("1.1.0", "1.1"));
    }
}
