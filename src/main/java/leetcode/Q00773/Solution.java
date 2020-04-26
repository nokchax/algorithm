package leetcode.Q00773;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    private static final int[] MX = new int[] {1, 0, -1, 0};
    private static final int[] MY = new int[] {0, 1, 0, -1};

    public int slidingPuzzle(int[][] board) {
        Set<Integer> cache = new HashSet<>();
        Queue<int[][]> q = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();

        q.add(board);
        count.add(0);

        while(!q.isEmpty()) {
            int[][] curBoard = q.poll();
            int curCount = count.poll();

            if(isGoal(curBoard)) {
                return curCount;
            }

            int xZero = 0, yZero = 0;
            boolean flag = false;

            for(int y = 0 ; y < curBoard.length ; ++y) {
                for(int x = 0 ; x < curBoard[0].length ; ++x) {
                    if(curBoard[y][x] == 0) {
                        xZero = x;
                        yZero = y;
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
            }

            for(int next = 0 ; next < MY.length ; ++next) {
                int xTarget = xZero + MX[next];
                int yTarget = yZero + MY[next];

                if(xTarget < 0 || yTarget < 0 || xTarget >= board[0].length || yTarget >= board.length) {
                    continue;
                }

                int[][] nextBoard = copy(curBoard);
                switchPosition(nextBoard, yZero, xZero, yTarget, xTarget);
                int value = arrayToInt(nextBoard);

                if(cache.contains(value)) {
                    continue;
                }

                q.add(nextBoard);
                count.add(curCount + 1);
                cache.add(value);
            }
        }

        return -1;
    }

    private void switchPosition(int[][] nextBoard, int yZero, int xZero, int yTarget, int xTarget) {
        int temp = nextBoard[yZero][xZero];
        nextBoard[yZero][xZero] = nextBoard[yTarget][xTarget];
        nextBoard[yTarget][xTarget] = temp;
    }

    private int arrayToInt(int[][] board) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int y = 0 ; y < board.length ; ++y) {
            for(int x = 0 ; x < board[0].length ; ++x) {
                stringBuilder.append(board[y][x]);
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    private int[][] copy(int[][] curBoard) {
        int[][] newBoard = new int[curBoard.length][];

        for(int i = 0 ; i < curBoard.length ; ++i) {
            newBoard[i] = curBoard[i].clone();
        }

        return newBoard;
    }

    private boolean isGoal(int[][] curBoard) {
        int target = 1;

        for(int y = 0 ; y < curBoard.length ; ++y) {
            for(int x = 0 ; x < curBoard[0].length ; ++x) {
                target %= 6;
                if(curBoard[y][x] != target++) {
                    return false;
                }
            }
        }

        return true;
    }
}
