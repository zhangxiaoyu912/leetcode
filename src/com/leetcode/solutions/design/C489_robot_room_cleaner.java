package com.leetcode.solutions.design;

import java.util.*;

public class C489_robot_room_cleaner {

    public interface Robot {
        void clean();
        boolean move();
        void turnLeft();
        void turnRight();
    }

    public void cleanRoom(Robot robot) {
        // use 'x@y' mark visited nodes, where x,y are integers tracking the coordinates
        dfs(robot, new HashSet<>(), 0, 0, 0); // 0: up, 90: right, 180: down, 270: left
    }

    public void dfs(Robot robot, Set<String> visited, int i, int j, int curDir) {
        String key = i + "@" + j;
        if (visited.contains(key)) return;
        visited.add(key);
        robot.clean();

        for (int n = 0; n < 4; n++) { // 4 directions fixme: line 50 has the logic of try 4 directions
            if(robot.move()) { // can go directly. Find the (x, y) for the next cell based on current direction
                int x = i, y = j;
                switch(curDir) {
                    case 0: // go up, reduce i
                        x = i-1;
                        break;
                    case 90: // go right
                        y = j+1;
                        break;
                    case 180: // go down
                        x = i+1;
                        break;
                    case 270: // go left
                        y = j-1;
                        break;
                    default:
                        break;
                }

                dfs(robot, visited, x, y, curDir);
                backtrack(robot);// fixme: the robot need to back to the existing spot after DFS
            }

            // turn to next direction
            robot.turnRight();// fixme: not necessary turn right, it means we need to try 4 directions
            curDir += 90;
            curDir %= 360;
        }
    }

    // go back to the starting position
    private void backtrack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
