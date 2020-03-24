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

        int[][] visited = new int[grid.length][grid[0].length];

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
            curPosition.move(); // 중요
            visited[curPosition.boxY][curPosition.boxX] = visited[curPosition.playerY][curPosition.playerX] + 1;
            checkReachableWithUpdatedGrid(q, curPosition);
        }

        return -1;
    }

    /*
        grid를 현재 position에 맞춰 업데이트 하고, 이전 상태로 복구
        주의할 점은 . 과 B를 덮어 씌우고 복구하는 과정에서 다른 문자열 T나 S를 덮어 씌우기 때문에
        T(목표점)에 대해서는 미리 저장해 두고 있어야한다.
     */
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

    /*
        일반적인 BFS 을 따름
        현재 플레이어 위치에서 박스의 상하좌우 까지 도달할 수 있는지 체크한 후
        positionQueue (탐색의 대상이 되는 위치들을 모은 큐)에 넣어준다.
        이때 중요한건 Set을 이용하여 박스의 위치와 플레이어의 위치 즉, 박스를 미는 뱡향을 저장해
        한번 밀었던 방향으로는 또 다시 밀지 않도록 방지한다.

        set을 사용하지 않는 경우 timeout 발생함.
     */
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

    /*
        position 클래스와 동일한데 따로 만든 이유는 position 클래스 내부의 move 때문임.
        set에 저장되어 비교를 할때 의도치 않은 결과를 발생시킴.
     */
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
