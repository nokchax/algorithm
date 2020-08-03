package leetcode.Q01431;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;

        for (int i = 0 ; i < candies.length ; ++i) {
            max = Math.max(max, candies[i]);
            candies[i] += extraCandies;
        }

        List<Boolean> answer = new ArrayList<>();
        for (int candy : candies) {
            answer.add(candy >= max);
        }

        return answer;
    }
}
