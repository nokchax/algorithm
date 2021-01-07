package test.t6.q3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static final int[] MX = {1, 0, -1, 0};
    private static final int[] MY = {0, -1, 0, 1};

    // not perfect solution
    // timeout? or correctness?
    // 시간 복잡도는 DFS, BFS 동일하므로 시간 복잡도 문제가 문제가 아니라면
    // 공간 복잡도 혹은 DFS stack overflow 문제일듯 싶다.
    // 따라서 BFS를 사용하는 것이 답일듯
    public int solution(int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];

        int area = 0;

        for (int y = 0 ; y < map.length ; ++y) {
            for (int x = 0 ; x < map[0].length ; ++x) {
                if (!visited[y][x]) {
                    //dfs(y, x, map, visited);
                    bfs(y, x, map, visited);
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

    private void bfs(int startY, int startX, int[][] map, boolean[][] visited) {
        visited[startY][startX] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX});

        while (!q.isEmpty()) {
            int curY = q.peek()[0];
            int curX = q.poll()[1];

            for (int direction = 0 ; direction < MX.length ; ++direction) {
                int nextY = curY + MY[direction];
                int nextX = curX + MX[direction];

                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length || visited[nextY][nextX]) {
                    continue;
                }

                if (map[curY][curX] == map[nextY][nextX]) {
                    visited[nextY][nextX] = true; // 넣기전에 true로 하지 않으면 같은 위치의 값이 여러번 들어갈 수 있으므로 중복의 연산의 가능성이 존재한다.
                    q.add(new int[]{nextY, nextX});
                }
            }
        }
    }
}
