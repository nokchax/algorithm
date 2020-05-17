package leetcode.Q01189;

public class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for (char c : text.toCharArray()) {
            arr[c - 'a']++;
        }

        arr['l'-'a'] = arr['l'-'a'] / 2;
        arr['o'-'a'] = arr['o'-'a'] / 2;

        char[] ballon = {'b','a','l','o','n'};

        int min = Integer.MAX_VALUE;
        for (char c : ballon) {
            int cnt = arr[c - 'a'];
            if (min > cnt) {
                min = cnt;
            }
        }

        return min;
    }
}
