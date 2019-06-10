package Q00121;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int minPosition = 0;

        int max = 0;
        for(int i = 1 ; i < prices.length ; ++i) {
            minPosition = prices[i] < prices[minPosition] ? i : minPosition;
            max = Math.max(max, prices[i] - prices[minPosition]);
        }

        return max;
    }
}
