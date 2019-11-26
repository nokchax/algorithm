package leetcode.Q01263;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final char WALL = '#';
    private static final char BOX = 'B';
    private static final char GOAL = 'T';
    private static final char PLAYER = 'S';

    private static final int[] mx = {1, 0, -1, 0};
    private static final int[] my = {0, 1, 0, -1};
    private static final int[] pushPositionX = {-1, 0, 1, 0};
    private static final int[] pushPositionY = {0, -1, 0, 1};

    private int[][] visited;

    public int minPushBox(char[][] grid) {
        if(!checkReachable(grid))
            return -1;

        visited = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; ++i)
            Arrays.fill(visited[i], -1);


        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        getPositionOfChar(grid, BOX, qy, qx);
        visited[qy.peek()][qx.peek()] = 0;

        while(!qx.isEmpty()) {
            int curX = qx.poll();
            int curY = qy.poll();

            if(grid[curY][curX] == GOAL) {
                print(visited);
                return visited[curY][curX];
            }

            for(int move = 0 ; move < my.length ; ++move) {
                int nextY = curY + my[move];
                int nextX = curX + mx[move];

                if(nextY < 0 || nextX < 0 || nextY >= grid.length || nextX >= grid[0].length || visited[nextY][nextX] > -1 || grid[nextY][nextX] == WALL)
                    continue;
                int pushY = curY + pushPositionY[move];
                int pushX = curX + pushPositionX[move];

                if(pushY < 0 || pushX < 0 || pushY >= grid.length || pushX >= grid[0].length || grid[pushY][pushX] == WALL)
                    continue;


                visited[nextY][nextX] = visited[curY][curX] + 1;
                qy.add(nextY);
                qx.add(nextX);
            }
        }

        print(visited);
        return -1;
    }

    private boolean checkReachable(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Integer> playerY = new LinkedList<>();
        Queue<Integer> playerX = new LinkedList<>();
        getPositionOfChar(grid, PLAYER, playerY, playerX);

        while(!playerX.isEmpty()) {
            int curY = playerY.poll();
            int curX = playerX.poll();
            if(grid[curY][curX] == BOX)
                return true;

            for(int move = 0 ; move < mx.length ; ++move) {
                int nextY = curY + my[move];
                int nextX = curX + mx[move];

                if(nextY < 0 || nextX < 0 || nextY >= grid.length || nextX >= grid[0].length || visited[nextY][nextX] || grid[nextY][nextX] == WALL)
                    continue;

                visited[nextY][nextX] = true;
                playerY.add(nextY);
                playerX.add(nextX);
            }
        }

        return false;
    }


    private void getPositionOfChar(char[][] grid, char targetChar, Queue<Integer> qy, Queue<Integer> qx) {
        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0 ; x < grid[0].length ; ++x) {
                if(grid[y][x] == targetChar) {
                    qy.add(y);
                    qx.add(x);
                    return;
                }
            }
        }
    }

    private void print(int[][] visited) {
        for(int y = 0 ; y < visited.length ; ++y) {
            for(int x = 0 ; x < visited[0].length ; ++x) {
                System.out.printf("%2d ", visited[y][x]);
            }
            System.out.println();
        }
    }
}
