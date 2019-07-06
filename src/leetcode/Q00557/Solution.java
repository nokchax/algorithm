package leetcode.Q00557;

public class Solution {
    public String reverseWords(String s) {
        String[] sub = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for(int i = sub.length - 1 ; i >= 0 ; --i) {
            sb.append(sub[i]).append(" ");
        }

        s = sb.reverse().toString();

        return s.trim();
    }
}
