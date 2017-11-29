package com.leetcode.solutions;

/**
 * path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class C71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return path;

        StringBuilder builder = new StringBuilder();
        int i = path.length() - 1;

        // get the final part
        if (path.charAt(i) == '/')
            i -= 1;

        while (path.charAt(i) != '/' && i >= 0) {
            builder.insert(0, path.charAt(i));
            i -= 1;
        }

//        while (i >= 0) {
//
//        }

        builder.insert(0, "/");
        return builder.toString();
    }

    public static void main(String[] strings) {
        C71 c = new C71();
        System.out.println(c.simplifyPath("/home/"));
    }
}
