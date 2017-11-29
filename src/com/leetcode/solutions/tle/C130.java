package com.leetcode.solutions.tle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 */
public class C130 {

    public class Position {
        public int x;

        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position))
                return false;

            Position position = (Position) o;
            return position.x == x && position.y == y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        Set<Position> flip = new HashSet<>();
        Set<Position> converted = new HashSet<>();
        Queue<Position> noFlip = new ArrayDeque<>();

        int x = board.length;
        int y = board[0].length;

        for (int i = 0; i < x; i ++) {
            for (int j = 0; j < y; j ++) {
                if (board[i][j] == 'O' &&
                        i != 0 && i != x - 1 &&
                        j != 0 && j != y - 1) {
                    flip.add(new Position(i, j));
                } else if (board[i][j] == 'O' && (i == x - 1 || i == 0 || j == y - 1 || j == 0)) {
                    noFlip.add(new Position(i, j));
                    converted.add(new Position(i, j));
                }
            }
        }

        while (!noFlip.isEmpty()) {
            Position position = noFlip.poll();
            if (position.getX() + 1 < x)
                convertIfConnected(board, position.getX() + 1, position.getY(), flip, noFlip, converted);
            if (position.getX() - 1 >= 0)
                convertIfConnected(board, position.getX() - 1, position.getY(), flip, noFlip, converted);
            if (position.getY() + 1 < y)
                convertIfConnected(board, position.getX(), position.getY() + 1, flip, noFlip, converted);
            if (position.getY() - 1 >= 0)
                convertIfConnected(board, position.getX(), position.getY() - 1, flip, noFlip, converted);
        }

        for (Position position : flip)
            board[position.getX()][position.getY()] = 'X';
    }

    private void convertIfConnected(char[][] board, int x, int y, Set<Position> flip, Queue<Position> noFlip, Set<Position> converted) {
        if (board[x][y] == 'O') {
            Position convert = new Position(x, y);
            if (flip.contains(convert))
                flip.remove(convert);
            if (!converted.contains(convert)) {
                noFlip.add(convert);
                converted.add(convert);
            }
        }
    }

    public static void main(String[] strings) {
        C130 c = new C130();
        char[][] board = new char[1][2];
        board[0][0] = 'O';
        board[0][1] = 'O';
        c.solve(board);
        System.out.println(board);
    }
}
