package Q00171;

public class Solution {
    public int titleToNumber(String s) {
        int answer = 0;

        for(int i = s.length() - 1 ; i >= 0 ; --i) {
            answer += (s.charAt(i) - 'A' + 1) * (int) Math.pow(26, s.length() - 1 - i);
        }

        return answer;
    }
}
