package leetcode.Q00289;

public class Solution {
    private static int[] mx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] my = {-1, -1, 0, 1, 1, 1, 0, -1};
    public void gameOfLife(int[][] board) {
        int[][] nextBoard = new int[board.length][board[0].length];

        for(int y = 0 ; y < board.length ; ++y) {
            for(int x = 0 ; x < board[0].length ; ++x) {
                nextBoard[y][x] = checkNear(board, y, x);
            }
        }

        for(int i = 0 ; i < board.length ; ++i) {
            for(int j = 0 ; j < board[0].length ; ++j) {
                board[i][j] = nextBoard[i][j];
            }
        }
    }

    private int checkNear(int[][] board, int y, int x) {
        int liveCell = 0;

        for(int i = 0 ; i < mx.length ; ++i) {
            int nx = x + mx[i];
            int ny = y + my[i];

            if(nx < 0 || ny < 0 || nx == board[0].length || ny == board.length)
                continue;

            if(board[ny][nx] == 1)
                liveCell++;
        }

        if(board[y][x] == 0) {
            if(liveCell == 3)
                return 1;
            else
                return 0;
        } else {
            switch (liveCell) {
                case 2:
                case 3:
                    return 1;

                default:
                    return 0;
            }
        }
    }
}
