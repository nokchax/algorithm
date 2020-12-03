package test.t5.q3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();

        assertThat(s.solution(new int[]{7, 3, 7, 3, 1, 3, 4, 1})).isEqualTo(5);
        assertThat(s.solution(new int[]{2, 1, 1, 3, 2, 1, 1, 3})).isEqualTo(3);
        assertThat(s.solution(new int[]{7, 5, 2, 7, 2, 7, 4, 7})).isEqualTo(6);
    }

}