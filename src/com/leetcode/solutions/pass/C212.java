package com.leetcode.solutions.pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C212 {

    // reuse C79 plus deep copy board each time
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet();
        if (board == null || board.length == 0 || board[0].length == 0)
            return new ArrayList();

        for (String word : words) {
            final char[][] temp = new char[board.length][];
            for (int i = 0; i < board.length; i++) {
                temp[i] = Arrays.copyOf(board[i], board[i].length);
            }
            if (exist(temp, word))
                set.add(word);
        }

        List<String> list = new ArrayList();
        for (String str : set)
            list.add(str);

        return list;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;

        // this check is good so that the recursive call don't have to check it before calling
        // hence less code
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
                    ||dfs(board, word, i+1, j, k+1)
                    ||dfs(board, word, i, j-1, k+1)
                    ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            board[i][j]=temp;
        }

        return false;
    }
}
