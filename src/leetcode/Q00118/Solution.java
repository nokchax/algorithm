package leetcode.Q00118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows < 1)
            return Collections.emptyList();

        List<List<Integer>> answer = new ArrayList<>(numRows);
        List<Integer> init = new ArrayList<>(1);
        init.add(1);
        answer.add(init);


        for(int i = 2 ; i <= numRows ; ++i) {
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);

            for(int j = 1 ; j < i - 1 ; ++j) {
                temp.add(answer.get(i - 2).get(j) + answer.get(i - 2).get(j - 1));
            }
            temp.add(1);
            answer.add(temp);
        }

        return answer;
    }
}
