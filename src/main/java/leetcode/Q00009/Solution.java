package leetcode.Q00009;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int mid = s.length() / 2;

        for (int i = 0 ; i < mid ; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1- i)) {
                return false;
            }
        }

        return true;
    }
}
