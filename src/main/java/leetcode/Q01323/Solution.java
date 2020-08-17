package leetcode.Q01323;

public class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        String updatedStr = str.replaceFirst("6", "9");

        return Integer.parseInt(updatedStr);
    }
}
