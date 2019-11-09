package leetcode.Q00030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if(s == null || words == null || words.length == 0 || s.length() == 0)
            return indices;

        int wordSize = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < words.length ; ++i) {
            int count = map.getOrDefault(words[i], 0);
            map.put(words[i], count + 1);
        }




        for(int start = 0 ; start < s.length() ; ++start) {
            Map<String, Integer> wordsAndCount = new HashMap<>(map);

            for(int i = start ; i <= s.length() - wordSize ; i = i + wordSize) {
                String target = s.substring(i, i + wordSize);

                if(wordsAndCount.isEmpty() || !wordsAndCount.containsKey(target)) {
                    break;
                }

                int curCount = wordsAndCount.get(target) - 1;

                if (curCount == 0) {
                    wordsAndCount.remove(target);
                } else {
                    wordsAndCount.put(target, curCount);
                }
            }

            if(wordsAndCount.isEmpty())
                indices.add(start);
        }


        return indices;
    }
}
