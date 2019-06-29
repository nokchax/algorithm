package leetcode.Q00905;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 % 2 == 0)
                    return -1;
                else if(o2 % 2 == 0)
                    return 1;
                return 0;
            }
        });

        for(int i = 0 ; i < A.length ; ++i)
            A[i] = list.get(i);

        return A;
    }
}
