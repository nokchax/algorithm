package leetcode.Q00121;

public class Solution3 {
    public int maxProfit(int[] prices) {
        int minProfit = Integer.MAX_VALUE;

        int max = 0;
        for(int i = 0 ; i < prices.length ; ++i) {
            if(prices[i] < minProfit)
                minProfit = prices[i];
            else
                max = Math.max(max, prices[i] - minProfit);
        }

        return max;
    }
}
