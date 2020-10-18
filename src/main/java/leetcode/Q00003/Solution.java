package leetcode.Q00003;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        Deque<Character> sub = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                max = Math.max(max, set.size());
                while (!sub.isEmpty()) {
                    Character first = sub.pollFirst();
                    set.remove(first);

                    if (first == c) {
                        break;
                    }
                }
            }

            set.add(c);
            sub.add(c);
        }

        return Math.max(set.size(), max);
    }
}
