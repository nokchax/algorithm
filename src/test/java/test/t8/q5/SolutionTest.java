package test.t8.q5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test() {
        Solution s = new Solution();

        assertThat(s.solution("onesevenfive")).isEqualTo("175");
        assertThat(s.solution("threetwo")).isEqualTo("32");
        assertThat(s.solution("fourthreenine")).isEqualTo("439");
        assertThat(s.solution("eight")).isEqualTo("8");
        assertThat(s.solution("fivetwoonetwo")).isEqualTo("5212");
    }
}