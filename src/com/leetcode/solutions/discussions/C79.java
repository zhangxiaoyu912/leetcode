package com.leetcode.solutions.discussions;

public class C79 {
    // below is the solution, it is tricky to use the # to mark and unmark
    // there are several other problems, for in place algorithm, mark and unmark with # can be a solution
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


    // this is my solution, it is little bit too much to use the map to track the visited node, which is buggy
//    public boolean exist(char[][] board, String word) {
//        if (board == null || board.length == 0 || board[0].length == 0)
//            return false;
//
//        int m = board.length;
//        int n = board[0].length;
//
//        for (int i = 0; i < m; i ++) {
//            for (int j = 0; j < n; j ++) {
//                Map<Integer, Set<Integer>> visited = new HashMap<>();
//                if (dfs(board, word, i, j, visited))
//                    return true;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean dfs(char[][] board, String word, int i, int j, Map<Integer, Set<Integer>> visited) {
//        if (word.length() == 0)
//            return true;
//        if (board[i][j] != word.charAt(0))
//            return false;
//
//        if (visited.containsKey(i) && visited.get(i).contains(j))
//            return false;
//        else {
//            Set<Integer> set;
//            if (visited.containsKey(i))
//                set = visited.get(i);
//            else
//                set = new HashSet<>();
//
//            set.add(j);
//            visited.put(i, set);
//        }
//
//        if (word.substring(1, word.length()).equals(""))
//            return true;
//
//        // go left
//        if (i - 1 >= 0) {
//            boolean exist = dfs(board, word.substring(1, word.length()), i - 1, j, visited);
//            if (exist)
//                return true;
//        }
//
//        // go right
//        if (i + 1 < board.length) {
//            boolean exist = dfs(board, word.substring(1, word.length()), i + 1, j, visited);
//            if (exist)
//                return true;
//        }
//
//        // go up
//        if (j - 1 >= 0) {
//            boolean exist = dfs(board, word.substring(1, word.length()), i, j - 1, visited);
//            if (exist)
//                return true;
//        }
//
//        // go down
//        if (j + 1 < board[0].length) {
//            boolean exist = dfs(board, word.substring(1, word.length()), i, j + 1, visited);
//            if (exist)
//                return true;
//        }
//
//        // no found in four directions
//        return false;
//    }

    public static void main(String[] strings) {
        C79 c = new C79();
        char[] char1 = new char[]{'A', 'B', 'C', 'E'};
        char[] char2 = new char[]{'S', 'F', 'E', 'S'};
        char[] char3 = new char[]{'A', 'D', 'E', 'E'};
        char[][] chars = new char[][]{char1, char2, char3};
//        char[] char1 = new char[]{'a'};
//        char[] char2 = new char[]{'a'};
//        char[] char3 = new char[]{'a', 'a', 'a', 'a'};
//        char[][] chars = new char[][]{char1};
        System.out.println(c.exist(chars, "ABCESEEEFS"));
    }
}
