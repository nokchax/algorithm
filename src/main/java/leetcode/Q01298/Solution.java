package leetcode.Q01298;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> sets = new HashSet<>();
        Set<Integer> key = new HashSet<>();

        int maximum = 0;

        for(int box : initialBoxes) {
            sets.add(box);
        }

        while(!sets.isEmpty()) {
            Integer[] boxes = new Integer[]{};
            sets.toArray(boxes);

            boxes = sets.toArray(boxes);
            for (Integer box : boxes) {
                if(status[box] == 0 && !key.contains(box)) {
                    continue;
                }

                maximum += candies[box];

                for(int newBox : containedBoxes[box]) {
                    sets.add(newBox);
                }

                for(int newKey : keys[box]) {
                    key.add(newKey);
                }

                sets.remove(box);
            }

            if(!isOpenableAnymore(sets, key, status)) {
                break;
            }
        }

        return maximum;
    }

    private boolean isOpenableAnymore(Set<Integer> sets, Set<Integer> key, int[] status) {
        for(int box : sets) {
            if(status[box] == 1) {
                return true;
            } else {
                if(key.contains(box)) {
                    return true;
                }
            }
        }

        return false;
    }
}
