package leetcode.Q01340;

import java.util.Arrays;

public class Solution {
    private int[] cache;

    public int maxJumps(int[] arr, int d) {
        cache = new int[arr.length];
        Arrays.fill(cache, -1);

        int max = -1;

        for (int i = 0 ; i < arr.length ; ++i) {
            max = Math.max(max, dfs(arr, d, i));
        }

        return max;
    }

    private int dfs(int[] arr, int d, int curIdx) {
        if (cache[curIdx] > 0) {
            return cache[curIdx];
        }

        int max = 1;
        int minIdx = Math.max(0, curIdx - d);
        for (int i = curIdx - 1 ; i >= minIdx ; --i) {
            if (arr[curIdx] > arr[i]) {
                max = Math.max(max, dfs(arr, d, i) + 1);
            } else {
                break;
            }
        }

        int maxIdx = Math.min(arr.length - 1, curIdx + d);
        for (int i = curIdx + 1 ; i <= maxIdx ; ++i) {
            if (arr[curIdx] > arr[i]) {
                max = Math.max(max, dfs(arr, d, i) + 1);
            } else {
                break;
            }
        }

        return cache[curIdx] = max;
    }
}
