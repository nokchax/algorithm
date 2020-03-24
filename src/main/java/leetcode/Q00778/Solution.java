package leetcode.Q00778;

import java.util.PriorityQueue;

public class Solution {
    private static int[] mx = {1, 0, -1, 0};
    private static int[] my = {0, -1, 0, 1};
    public int swimInWater(int[][] grid) {
        int time = grid[0][0];
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        PriorityQueue<Position> pq = new PriorityQueue<>();
        visited[0][0] = true;
        pq.add(new Position(0, 0, time));

        while(!pq.isEmpty()) {
            Position curPosition = pq.poll();

            time = Math.max(time, curPosition.getTime());

            if(curPosition.getY() == grid.length - 1 && curPosition.getX() == grid[0].length -1) {
                return time;
            }

            for(int move = 0 ; move < mx.length ; ++move) {
                int nextY = curPosition.getY() + my[move];
                int nextX = curPosition.getX() + mx[move];

                if(nextY < 0 || nextX < 0 || nextY >= grid.length || nextX >= grid[0].length || visited[nextY][nextX]) {
                    continue;
                }

                pq.add(new Position(nextY, nextX, grid[nextY][nextX]));
                visited[nextY][nextX] = true;
            }
        }

        return -1;
    }

    protected class Position implements Comparable {
        private int y;
        private int x;
        private int time;

        Position(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getTime() {
            return time;
        }


        @Override
        public int compareTo(Object o) {
            return this.time - ((Position) o).time;
        }
    }
}
