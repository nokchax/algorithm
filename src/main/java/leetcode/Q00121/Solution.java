package leetcode.Q00121;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] minPosition = new int[prices.length + 1];

        int max = 0;
        for(int i = 1 ; i < prices.length ; ++i) {
            minPosition[i] = prices[i] < prices[minPosition[i - 1]] ? i : minPosition[i - 1];
            max = Math.max(max, prices[i] - prices[minPosition[i]]);
        }

        return max;
    }
}
