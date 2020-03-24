package leetcode.Q00200;

public class Solution {
    private static boolean[][] visited;
    private static int[] mx = new int[]{1, 0, -1, 0};
    private static int[] my = new int[]{0, -1, 0, 1};
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;

        visited = new boolean[grid.length][grid[0].length];

        int count = 0 ;
        for(int y = 0 ; y < grid.length ; ++y) {
            for(int x = 0 ; x < grid[0].length ; ++x) {
                if(!visited[y][x] && grid[y][x] == '1') {
                    dfs(grid, y, x);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int y, int x) {
        visited[y][x] = true;

        for(int i = 0 ; i < mx.length ; ++i) {
            int ny = y + my[i];
            int nx = x + mx[i];

            if(ny < 0 || nx < 0 || ny >= grid.length || nx >= grid[0].length || visited[ny][nx] || grid[ny][nx] == '0')
                continue;

            dfs(grid, ny, nx);
        }
    }
}
