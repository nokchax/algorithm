package test.t5.q3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{7,3,7,3,1,3,4,1}));
        System.out.println(s.solution(new int[]{2,1,1,3,2,1,1,3}));
        System.out.println(s.solution(new int[]{7,5,2,7,2,7,4,7}));
    }

}