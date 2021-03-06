package test.t8.q3;

import java.util.Stack;

public class Solution {
    int solution(int[][] board) {
        return tilt(board, 0, 0);
    }

    int tilt(int[][] board, int count, int direction) {
        if (count > 5) {
            return getMaxNum(board);
        }

        board = moveAndSum(board, direction);

        int max = -1;
        for (int i = 0 ; i < 4 ; ++i) {
            int[][] newBoard = copy(board);
            max = Math.max(tilt(newBoard, count + 1, i), max);
        }

        return max;
    }

    private int[][] moveAndSum(int[][] board, int direction) {
        switch(direction) {
            case 0: // 오른쪾으로
                return tiltRight(board);
            case 1: // 위로
                return tiltUp(board);
            case 2: // 왼쪽으로
                return tiltLeft(board);
            case 3: // 아래로
                return tiltDown(board);
        }
        return new int[][]{};
    }

    private int[][] tiltUp(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int x = 0 ; x < board[0].length ; ++x) {
            Stack<Integer> stack = new Stack<>();
            for (int y = board.length - 1 ; y >= 0 ; --y) {
                if (board[y][x] != 0) {
                    stack.push(board[y][x]);
                }
            }

            Stack<Integer> added = add(stack);
            for (int t = added.size() - 1 ; t >= 0 ; --t) {
                newBoard[x][t] = added.pop();
            }
        }
        return newBoard;
    }

    private int[][] tiltDown(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int x = 0 ; x < board.length ; ++x) {
            Stack<Integer> stack = new Stack<>();
            for (int y = 0 ; y < board[0].length ; ++y) {
                if (board[y][x] != 0) {
                    stack.push(board[y][x]);
                }
            }

            Stack<Integer> added = add(stack);
            for (int t = board.length - added.size() ; t < board.length ; ++t) {
                newBoard[t][x] = added.pop();
            }
        }
        return newBoard;
    }

    private int[][] tiltLeft(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int y = 0 ; y < board.length ; ++y) {
            Stack<Integer> stack = new Stack<>();
            for (int x = board[0].length - 1 ; x >= 0 ; --x) {
                if (board[y][x] != 0) {
                    stack.push(board[y][x]);
                }
            }

            Stack<Integer> added = add(stack);
            for (int t = added.size() - 1 ; t >= 0 ; --t) {
                newBoard[y][t] = added.pop();
            }
        }
        return newBoard;
    }

    public int[][] tiltRight(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int y = 0 ; y < board.length ; ++y) {
            Stack<Integer> stack = new Stack<>();
            for (int x = 0 ; x < board[0].length ; ++x) {
                if (board[y][x] != 0) {
                    stack.push(board[y][x]);
                }
            }

            Stack<Integer> added = add(stack);
            for (int t = board.length - added.size() ; t < board.length ; ++t) {
                newBoard[y][t] = added.pop();
            }
        }
        return newBoard;
    }

    private Stack<Integer> add(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        Stack<Integer> sum = new Stack<>();
        int prev = 0;
        while (!stack.isEmpty()) {
            prev = stack.pop();

            if (stack.isEmpty()) {
                sum.push(prev);
                break;
            }

            if (prev == stack.peek()) {
                sum.push(prev*2);
                stack.pop();
            } else {
                sum.push(prev);
            }
        }

        return sum;
    }

    private int[][] copy(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int i = 0 ; i < board.length ; ++i) {
            for (int j = 0 ; j < board[0].length ; ++j) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    int getMaxNum(int[][] board) {
        int max = board[0][0];

        for (int i = 0 ; i < board.length ; ++i) {
            for (int j = 0 ; j < board[0].length ; ++j) {
                max = Math.max(board[i][j], max);
            }
        }

        return max;
    }
}
