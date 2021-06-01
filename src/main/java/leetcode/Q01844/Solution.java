package leetcode.Q01844;

public class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0 ; i < chars.length ; ++i) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                sb.append((char)(chars[i - 1] + chars[i] - '0'));
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
