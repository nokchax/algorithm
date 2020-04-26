package leetcode.Q00773;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void test(int[][] board, int answer) {
        Solution solution = new Solution();

        assertThat(solution.slidingPuzzle(board)).isEqualTo(answer);
    }

    private static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(
                        new int[][] {{1, 2, 3}, {4, 0, 5}},
                        1
                ),
                Arguments.of(
                        new int[][] {{1, 2, 3}, {5, 4, 0}},
                        -1
                ),
                Arguments.of(
                        new int[][] {{4, 1, 2}, {5, 0, 3}},
                        5
                ),
                Arguments.of(
                        new int[][] {{3, 2, 4}, {1, 5, 0}},
                        14
                )
        );
    }
}