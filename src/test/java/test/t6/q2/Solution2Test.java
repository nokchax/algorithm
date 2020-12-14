package test.t6.q2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {

    @Test
    public void test() {
        Solution s = new Solution();
        Solution2 s2 = new Solution2();

        for (int i = 99999 ; i < 1000000 ; ++i) {
            for (int j = 0 ; j < i ; ++j) {
                assertThat(s.solution(i, j)).isEqualTo(s2.solution(i, j));
            }
        }
    }

}