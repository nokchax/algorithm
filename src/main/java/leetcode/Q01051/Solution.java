package leetcode.Q01051;

import java.util.Arrays;

public class Solution {
    public int heightChecker(int[] heights) {
        int[] origin = heights.clone();
        Arrays.sort(heights);
        int diffCount = 0;

        for(int i = 0 ; i < origin.length ; ++i)
            if(origin[i] != heights[i])
                diffCount++;

        return diffCount;
    }
}
