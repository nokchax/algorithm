package leetcode.Q01284;

import java.util.*;

public class SolutionUsingBitOperation {
    private static int[] mx = {0, 0, 1, 0, -1};
    private static int[] my = {0, 1, 0, -1, 0};

    public int minFlips(int[][] mat) {
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        int start = 0;

        for(int y = 0 ; y < mat.length ; ++y) {
            for(int x = 0 ; x < mat[0].length ; ++x) {
                start |= mat[y][x] << (y * mat[0].length + x);
            }
        }

        set.add(start);
        q.add(new int[]{start, 0});

        while(!q.isEmpty()) {
            int curPosition = q.peek()[0];
            int count = q.poll()[1];

            if(curPosition == 0) {
                return count;
            }

            for(int y = 0 ; y < mat.length ; ++y) {
                for(int x = 0 ; x < mat[0].length ; ++x) {
                    int newPosition = curPosition;

                    for(int move = 0 ; move < mx.length ; ++move) {
                        int nextY = y + my[move];
                        int nextX = x + mx[move];

                        if(nextY < 0 || nextX < 0 || nextY >= mat.length || nextX >= mat[0].length) {
                            continue;
                        }

                        newPosition ^= 1 << (nextY * mat[0].length + nextX);
                    }

                    if(set.contains(newPosition)) {
                        continue;
                    }

                    set.add(newPosition);
                    q.add(new int[]{newPosition, count + 1});
                }
            }
        }

        return -1;
    }
}
