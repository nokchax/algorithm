package test.t8.q3;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        int[][] example = new int[][] {
                {2, 4, 8, 2}, {2, 2, 2, 2}, {0, 4, 2, 4}, {2, 2, 2, 4}
        };

        Solution solution = new Solution();
        int x = solution.solution(example);
        System.out.println(x);
    }
}