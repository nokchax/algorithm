package leetcode.Q01147;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "ghiabcdefhelloadamhelloabcdefghi, 7",
            "merchant, 1",
            "antaprezatepzapreanta, 11",
            "aaa, 3",
            "elvtoelvto, 2"
    })
    void test(String text, int expectedOutput) {
        Solution s = new Solution();

        int length = s.longestDecomposition(text);

        assertThat(length).isEqualTo(expectedOutput);
    }
}