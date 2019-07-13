package leetcode.Q00804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static String[] morses = new String[] {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()) {
                sb.append(morses[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
