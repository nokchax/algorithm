package test.t8.q4;

import java.util.ArrayList;

public class Solution {
    public int solution(Integer[] arr) {
        int count = 0;
        while (true) {
            if (arr.length == 1 && arr[0] == 1) {
                return count;
            }

            count++;

            ArrayList<Integer> newArr = new ArrayList<>();

            for (int i = 0 ; i < arr.length ; ) {
                int target = arr[i];
                int dupCount = 1;
                int gap = 1;
                for (; i + gap < arr.length ; ++gap) {
                    if (target == arr[i + gap]) {
                        dupCount++;
                    } else {
                        break;
                    }
                }
                i += gap;
                newArr.add(dupCount);
            }

            arr = newArr.toArray(new Integer[0]);
        }
    }
}
