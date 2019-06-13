package leetcode.Q00070;

public class Solution2 {// memory 사용량이 별 차이가 없네..
    public int climbStairs(int n) {
        int fore = 1, back = 1;

        for(int i = 2 ; i <= n ; ++i) {
            int temp = fore + back;
            fore = back;
            back = temp;
        }

        return back;
    }
}
