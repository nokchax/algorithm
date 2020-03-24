package leetcode.Q00500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final char[] upper = {'q','w','e','r','t','y','u','i','o','p'};
    private static final char[] middle = {'a','s','d','f','g','h','j','k','l'};
    private static final char[] lower = {'z','x','c','v','b','n','m'};

    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char u : upper)
            map.put(u, 0);
        for (char m : middle)
            map.put(m, 1);
        for (char l : lower)
            map.put(l, 2);

        List<String> answer = new ArrayList<>();
        for(String word : words) {
            String lowerWrod = word.toLowerCase();
            int row = map.get(lowerWrod.charAt(0));
            boolean flag = true;
            for(char c : lowerWrod.toCharArray()) {
                if(map.get(c) != row) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                answer.add(word);
        }

        String[] output = new String[answer.size()];

        return answer.toArray(output);
    }
}
