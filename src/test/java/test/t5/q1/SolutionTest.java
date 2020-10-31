package test.t5.q1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {
    @Test
    void test() {
        Solution s = new Solution();

        String[] card = new String[] {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = new String[]{"GPQM", "GPMZ", "EFU", "MMNA"};

        String[] solution = s.solution(card, word);
        System.out.println(Arrays.toString(solution));

        card = new String[] {"AABBCCDD", "KKKKJJJJ", "MOMOMOMO"};
        word = new String[]{"AAAKKKKKMMMMM", "ABCDKJ"};

        System.out.println(Arrays.toString(s.solution(card, word)));

    }
}