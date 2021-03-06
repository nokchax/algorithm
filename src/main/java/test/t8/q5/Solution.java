package test.t8.q5;

import java.util.Arrays;
import java.util.List;

public class Solution {
    List<String> DIGIT = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    public String solution(String number) {
        int idx = 0;

        StringBuffer sb = new StringBuffer();
        while (!(idx >= number.length())) {
            for (int i = 0 ; i < 10 ; ++i) {
                String x = DIGIT.get(i);
                if (idx + x.length() > number.length()) {
                    continue;
                }

                boolean match = compare(number, idx, x);
                if (match) {
                    sb.append(i);
                    idx += x.length();
                    break;
                }
            }
        }

        return sb.toString();
    }

    private boolean compare(String number, int idx, String x) {
        for (int i = 0 ; i < x.length() ; ++i) {
            if (number.charAt(idx + i) != x.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
