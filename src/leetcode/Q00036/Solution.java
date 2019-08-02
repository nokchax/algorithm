package leetcode.Q00036;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0 ; i < board.length ; ++i) {
            if(!checkHorizontal(board, i))
                return false;
            if(!checkVertical(board, i))
                return false;
            if(!checkSquare(board, i))
                return false;
        }

        return true;
    }

    private boolean checkSquare(char[][] board, int i) {
        boolean[] check = new boolean[board.length];
        int startX = (i % 3) * 3;
        int startY = (i / 3) * 3;

        for(int y = startY ; y < startY + 3 ; ++y) {
            for(int x = startX ; x < startX + 3 ; ++x) {
                if(board[y][x] == '.')
                    continue;
                if(check[board[y][x] - '1'])
                    return false;
                check[board[y][x] - '1'] = true;
            }
        }

        return true;
    }

    private boolean checkVertical(char[][] board, int i) {
        boolean[] check = new boolean[board.length];
        for(int j = 0 ; j < board.length ; ++j) {
            if(board[j][i] == '.')
                continue;
            if(check[board[j][i] - '1'])
                return false;
            check[board[j][i] - '1'] = true;
        }
        return true;
    }

    private boolean checkHorizontal(char[][] board, int i) {
        boolean[] check = new boolean[board.length];
        for(int j = 0 ; j < board.length ; ++j) {
            if(board[i][j] == '.')
                continue;
            if(check[board[i][j] - '1'])
                return false;
            check[board[i][j] - '1'] = true;
        }
        return true;
    }
}
