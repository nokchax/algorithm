package leetcode.Q00980;

public class Solution {
    private static int[] MX = {1, 0, -1, 0};
    private static int[] MY = {0, -1, 0, 1};
    
    public int uniquePathsIII(int[][] grid) {
        int totalZero = 0;
        int answer = 0;
        int sx = 0, sy = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0; x < grid[0].length; ++x) {
                switch (grid[y][x]) {
                    case 0:
                        totalZero++;
                        break;
                    case 1:
                        sx = x;
                        sy = y;
                        break;
                }
            }
        }

        for(int direction = 0 ; direction < MX.length ; ++direction) {
            visited = new boolean[grid.length][grid[0].length];

            int startX = sx + MX[direction];
            int startY = sy + MY[direction];

            if(!(startX < 0 || startY < 0 || startX >= grid[0].length || startY >= grid.length || grid[startY][startX] == -1 || visited[startY][startX]))
                answer += DFS(grid, visited, startX, startY, 0, totalZero);
        }

        return answer;
    }

    private int DFS(int[][] grid, boolean[][] visited, int curX, int curY, int zeroCount, int totalZero) {
        if(grid[curY][curX] == 2) {
            if(totalZero == zeroCount)
                return 1;
        }

        if(grid[curY][curX] == -1 || grid[curY][curX] == 1)
            return 0;

        visited[curY][curX] = true;
        int answer = 0;

        for(int direction = 0 ; direction < MX.length ; ++direction) {
            int nextX = curX + MX[direction];
            int nextY = curY + MY[direction];

            if(nextX < 0 || nextY < 0 || nextX >= grid[0].length || nextY >= grid.length || grid[nextY][nextX] == -1 || visited[nextY][nextX])
                continue;

            answer += DFS(grid, visited, nextX, nextY, zeroCount + 1, totalZero);
        }

        visited[curY][curX] = false;
        return answer;
    }

}
