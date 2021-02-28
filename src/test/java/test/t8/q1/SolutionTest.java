package test.t8.q1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void test() {
        Solution s = new Solution();

        assertThat(s.solution(new String[]{"12", "2", "5", "+", "*", "9", "3", "/", "-"})).isEqualTo(81);
    }

}