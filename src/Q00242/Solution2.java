package Q00242;

public class Solution2 {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] count = new int['z' - 'a' + 1];

        for(int i = 0 ; i < s.length() ; ++i)
            count[s.charAt(i) - 'a']++;

        for(int i = 0 ; i < t.length() ; ++i) {
            int position = t.charAt(i) - 'a';
            if(count[position] == 0)
                return false;

            count[position]--;
        }

        return true;
    }
}
