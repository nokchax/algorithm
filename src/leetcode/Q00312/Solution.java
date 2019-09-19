package leetcode.Q00312;

public class Solution {
    static int[][] cache;
    public int maxCoins(int[] nums) {
        cache = new int[nums.length][nums.length];

        int max = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length ; ++i) {
            max = Math.max(max, calcMax(i, -1, i));
            int leftMax = calcMax(i, -1, i);
            int rightMax = calcMax(i, i, nums.length - 1);

        }

        return 1;
    }

    private int calcMax(int pick, int leftLimit, int rightLimit) {
        if()


        return -1;
    }

    private int getMax(int max) {
        return 0;
    }
}
