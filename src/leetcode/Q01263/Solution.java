package leetcode.Q01263;

import java.util.*;

public class Solution {
    private static final char WALL = '#';
    private static final char BOX = 'B';
    private static final char GOAL = 'T';
    private static final char PLAYER = 'S';

    private static final int[] mx = {1, 0, -1, 0};
    private static final int[] my = {0, 1, 0, -1};
    private int goalY = -1, goalX = -1;

    private int[][] visited;
    private char[][] grid;
    private Set<Way> ways = new HashSet<>();


    public int minPushBox(char[][] grid) {
        this.grid = grid;
        Queue<Position> q = new LinkedList<>();
        Position initPosition = new Position();
        checkInitPosition(initPosition);
        checkReachable(q, initPosition);

        if(q.isEmpty())
            return -1;

        visited = new int[grid.length][grid[0].length];

        for(int i = 0 ; i < grid.length ; ++i)
            Arrays.fill(visited[i], -1);

        visited[initPosition.boxY][initPosition.boxX] = 0;

        while(!q.isEmpty()) {
            Position curPosition = q.poll();

            if(curPosition.boxY == goalY && curPosition.boxX == goalX)
                return visited[curPosition.boxY][curPosition.boxX];

            if(!curPosition.isBoxMovable())
                continue;

            // change push direction & update visited
            curPosition.move();
            visited[curPosition.boxY][curPosition.boxX] = visited[curPosition.playerY][curPosition.playerX] + 1;
            checkReachableWithUpdatedGrid(q, curPosition);
        }

        return -1;
    }

    private void checkReachableWithUpdatedGrid(Queue<Position> positionQueue, Position curPosition) {
        int originBoxY = -1, originBoxX = -1;

        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0 ; x < grid[0].length ; ++x) {
                if(grid[y][x] == BOX) {
                    originBoxY = y;
                    originBoxX = x;
                }
            }

            if(originBoxX > -1)
                break;
        }

        grid[originBoxY][originBoxX] = '.';
        grid[curPosition.boxY][curPosition.boxX] = BOX;
        checkReachable(positionQueue, curPosition);
        grid[curPosition.boxY][curPosition.boxX] = '.';
        grid[originBoxY][originBoxX] = BOX;
    }

    private void checkReachable(Queue<Position> positionQueue, Position position) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Integer> qy = new LinkedList<>();
        Queue<Integer> qx = new LinkedList<>();
        qy.add(position.playerY);
        qx.add(position.playerX);
        visited[position.playerY][position.playerX] = true;

        while(!qy.isEmpty()) {
            int curY = qy.poll();
            int curX = qx.poll();

            for(int move = 0 ; move < mx.length ; ++move) {
                int nextY = curY + my[move];
                int nextX = curX + mx[move];

                if(isNotCandidate(nextY, nextX) || visited[nextY][nextX])
                    continue;

                if(nextY == position.boxY && nextX == position.boxX) {
                    Position newPosition = new Position(position.boxY, position.boxX, curY, curX);
                    Way newWay = new Way(position.boxY, position.boxX, curY, curX);
                    if(!ways.contains(newWay)) {
                        ways.add(newWay);
                        positionQueue.add(newPosition);
                    }
                    continue;
                }

                visited[nextY][nextX] = true;
                qy.add(nextY);
                qx.add(nextX);
            }
        }
    }

    private boolean isNotCandidate(int y, int x) {
        return y < 0 || x < 0 || y >= grid.length || x >= grid[0].length || grid[y][x] == WALL;
    }

    private void checkInitPosition(Position position) {
        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0 ; x < grid[0].length ; ++x) {
                if(grid[y][x] == BOX) {
                    position.boxY = y;
                    position.boxX = x;
                } else if(grid[y][x] == PLAYER) {
                    position.playerY = y;
                    position.playerX = x;
                } else if(grid[y][x] == GOAL) {
                    goalY = y;
                    goalX = x;
                }
            }
        }
    }

    protected class Position {
        int boxY, boxX, playerX, playerY;

        Position() {}

        Position(int boxY, int boxX, int playerY, int playerX) {
            this.boxY = boxY;
            this.boxX = boxX;
            this.playerY = playerY;
            this.playerX = playerX;
        }

        int nextBoxY() {
            return this.boxY * 2 - playerY;
        }

        int nextBoxX() {
            return this.boxX * 2 - playerX;
        }

        boolean isBoxMovable() {
            return !isNotCandidate(this.nextBoxY(), this.nextBoxX());
        }

        void move() {
            int nextBoxY = this.nextBoxY();
            int nextBoxX = this.nextBoxX();
            this.playerY = this.boxY;
            this.playerX = this.boxX;
            this.boxY = nextBoxY;
            this.boxX = nextBoxX;
        }
    }

    protected class Way {
        int boxY, boxX, playerY, playerX;

        Way(int boxY, int boxX, int playerY, int playerX) {
            this.boxX = boxX;
            this.boxY = boxY;
            this.playerY = playerY;
            this.playerX = playerX;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Way way = (Way) o;
            return boxY == way.boxY &&
                    boxX == way.boxX &&
                    playerY == way.playerY &&
                    playerX == way.playerX;
        }

        @Override
        public int hashCode() {
            return Objects.hash(boxY, boxX, playerY, playerX);
        }
    }
}
