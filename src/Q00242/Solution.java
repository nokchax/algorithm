package Q00242;

public class Solution {
    public boolean isAnagram(String s, String t) { //circulation
        if(s == null || t == null || s.length() != t.length())
            return false;

        int fore = 0;

        for( ; fore < s.length() ; ++fore) {
            int index = (fore + s.length() - 1) % s.length();
            if(!(s.charAt(fore) == t.charAt(0) && s.charAt(index) == t.charAt(t.length() - 1)))
                continue;
            boolean flag = true;
            for(int i = 0 ; i < t.length() ; ++i) {
                if(t.charAt(i) != s.charAt((fore + i) % s.length())) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }

        return false;
    }
}
