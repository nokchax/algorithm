package test.t8.q4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution s = new Solution();

        assertThat(s.solution(new Integer[]{1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3})).isEqualTo(6);
        assertThat(s.solution(new Integer[]{1,2,3})).isEqualTo(3);
        assertThat(s.solution(new Integer[]{2,2,1,1,2,2,1,1,2,2,2,1,2})).isEqualTo(5);
        assertThat(s.solution(new Integer[]{2})).isEqualTo(1);
        assertThat(s.solution(new Integer[]{1})).isEqualTo(0);
    }
}