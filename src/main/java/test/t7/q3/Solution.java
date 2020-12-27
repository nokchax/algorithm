package test.t7.q3;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public String solution(String riddle) {
        if (riddle.equals("?")) {
            return "a";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < riddle.length() ; ++i) {
            char curChar = riddle.charAt(i);

            // 일반 문자면 그냥 그대로
            if (curChar != '?') {
                sb.append(curChar);
                continue;
            }

            // ?일경우에는
            sb.append(getRandomChar(sb.length() == 0 ? null : sb.charAt(sb.length() - 1), i + 1 == riddle.length() ? null : riddle.charAt(i + 1)));
        }

        return sb.toString();
    }

    private char getRandomChar(Character prev, Character next) {
        int i = ThreadLocalRandom.current().nextInt(26);

        if ((prev != null && prev - 'a' == i) || (next != null && next - 'a' == i)) {
            return getRandomChar(prev, next);
        }

        return (char) (i + 'a');
    }

    private char getRandomChar2(Character prev, Character next) {
        int ch = ThreadLocalRandom.current().nextInt('a', 'z' + 1);

        if ((prev != null && prev == ch) || (next != null && next == ch)) {
            return getRandomChar2(prev, next);
        }

        return (char) ch;
    }
}
