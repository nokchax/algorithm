package leetcode.Q00387;

public class Solution {
    public int firstUniqChar(String s) {
        int[] stack = new int['z' - 'a' + 1];
        for(int i = 0 ; i < s.length() ; ++i) {
            stack[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s.length() ; ++i)
            if(stack[s.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
