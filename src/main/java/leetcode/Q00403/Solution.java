package leetcode.Q00403;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canCross(int[] stones) {
        List<Integer>[] cache = (List<Integer>[]) new ArrayList[stones.length];

        for (int i = 0 ; i < stones.length ; ++i) {
            cache[i] = new ArrayList<>();
        }

        cache[0].add(0);
        for (int i = 1 ; i < stones.length ; ++i) {
            for (int j = 0 ; j < i ; ++j) {
                for (int position : cache[j]) {
                    if (stones[i] >= stones[j] + position - 1 &&
                            stones[i] <= stones[j] + position + 1) {
                        cache[i].add(stones[i] - stones[j]);
                        break;
                    }
                }
            }
        }

        return !cache[stones.length - 1].isEmpty();
    }

}
