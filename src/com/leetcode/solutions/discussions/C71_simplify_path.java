package com.leetcode.solutions.discussions;

import java.util.LinkedList;
import java.util.Stack;

public class C71_simplify_path {
    public String simplifyPath(String path) {
        // the key idea is using a stack to track all sub string from right to left

        Stack<String> stack = new Stack<String>();

        int start = 0;
        for(int i=1; i<path.length(); i++){
            if(path.charAt(i) == '/'){
                stack.push(path.substring(start, i));
                start = i;
            }else if(i==path.length()-1){
                stack.push(path.substring(start));
            }
        }

        // serve as a queue
        LinkedList<String> result = new LinkedList<String>();
        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();

            if(top.equals("/.") || top.equals("/")){
                //nothing
            }else if(top.equals("/..")){
                back++;
            }else{
                if(back > 0){
                    back--;
                }else{
                    result.push(top);
                }
            }
        }

        //if empty, return "/"
        if(result.isEmpty()){
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            String s = result.pop();
            sb.append(s);
        }

        return sb.toString();
    }
}
