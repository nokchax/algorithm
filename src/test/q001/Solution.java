package test.q001;

public class Solution {
    public int solution(String s) {
        int[] forwardCount = new int[s.length()];
        int[] backwardCount = new int[s.length()];

        if(s.charAt(0) == 'B') {
            forwardCount[0] = 1;
        }
        if(s.charAt(s.length() - 1) == 'A') {
            backwardCount[s.length() - 1] = 1;
        }

        for(int i = 1 ; i < s.length() ; ++i) {
            forwardCount[i] = forwardCount[i - 1] + (s.charAt(i) == 'B' ? 1 : 0);
        }

        for(int i = s.length() - 2 ; i >= 0 ; --i) {
            backwardCount[i] = backwardCount[i + 1] + (s.charAt(i) == 'A' ? 1 : 0);
        }

        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < s.length() - 1 ; ++i) {
            if(forwardCount[i] != forwardCount[i + 1]) {
                min = Math.min(min, forwardCount[i] + backwardCount[i + 1]);
            }
        }
        min = Math.min(min, forwardCount[s.length() - 1]);

        for(int i = s.length() - 1 ; i > 0 ; --i) {
            if(backwardCount[i] != backwardCount[i - 1]) {
                min = Math.min(min, backwardCount[i] + forwardCount[i - 1]);
            }
        }

        min = Math.min(min, backwardCount[0]);
        return min;
    }
}
