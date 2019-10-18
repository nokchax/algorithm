package leetcode.Q00765;

import java.util.*;

public class Solution {
    /*
        time exceeded
     */
    public int minSwapsCouples(int[] row) {
        Set<String> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> distance = new LinkedList<>();

        set.add(Arrays.toString(row));
        q.add(row);
        distance.add(0);

        while(!q.isEmpty()) {
            int curDistance = distance.poll();
            int[] curRow = q.poll();

            if(isAllCoupleHoldingHands(curRow))
                return curDistance;

            for(int i = 0 ; i < row.length ; ++i) {
                int[] swapped = swap(curRow.clone(), i);
                if(swapped.length == 0)
                    continue;

                String swappedStr = Arrays.toString(swapped);

                if(!set.contains(swappedStr)) {
                    set.add(swappedStr);
                    q.add(swapped);
                    distance.add(curDistance + 1);
                }
            }
        }


        return -1;
    }

    private int[] swap(int[] arr, int i) {
        int targetNum = arr[i];
        int swapTargetIdx = (i % 2 == 0) ? i + 1 : i - 1;
        int coupleNum = (targetNum % 2 == 0) ? targetNum + 1 : targetNum - 1;

        int swapCoupleTargetIdx = 0;
        for(int j = 0 ; j < arr.length ; ++j) {
            if(arr[j] == coupleNum) {
                swapCoupleTargetIdx = j;
                break;
            }
        }

        if(Math.abs(i - swapCoupleTargetIdx) == 1)
            return new int[] {};

        int temp = arr[swapTargetIdx];
        arr[swapTargetIdx] = arr[swapCoupleTargetIdx];
        arr[swapCoupleTargetIdx] = temp;

        return arr;
    }

    private boolean isAllCoupleHoldingHands(int[] row) {
        for(int i = 0 ; i < row.length ; i += 2) {
            if(Math.abs(row[i + 1] - row[i]) == 1)
                return false;
        }

        return true;
    }
}
