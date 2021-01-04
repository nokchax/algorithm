package test.t6.q3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int[] MX = {1, 0, -1, 0};
    private static final int[] MY = {0, -1, 0, 1};

    // not perfect solution
    // timeout? or correctness?
    public int solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        int area = 0;

        for (int y = 0 ; y < map.length ; ++y) {
            for (int x = 0 ; x < map[0].length ; ++x) {
                if (!visited[y][x]) {
                    dfs(y, x, map, visited);
                    area++;
                }
            }
        }

        return area;
    }

    private void dfs(int curY, int curX, int[][] map, boolean[][] visited) {
        visited[curY][curX] = true;
        int curVal = map[curY][curX];

        for (int move = 0 ; move < MX.length ; ++move) {
            int nextY = curY + MY[move];
            int nextX = curX + MX[move];

            if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length || visited[nextY][nextX]) {
                continue;
            }

            if (curVal == map[nextY][nextX]) {
                dfs(nextY, nextX, map, visited);
            }
        }
    }

    private void bfs(int curY, int curX, int[][] map, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{curY, curX});

        while (!q.isEmpty()) {
            int[] curPosition = q.poll();
            visited[curPosition[0]][curPosition[1]] = true;

            for (int move = 0 ; move < MX.length ; ++move) {
                int nextY = curY + MY[move];
                int nextX = curX + MX[move];

                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length || visited[nextY][nextX]) {
                    continue;
                }

                if (map[curPosition[0]][curPosition[1]] == map[nextY][nextX]) {
                    q.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}
