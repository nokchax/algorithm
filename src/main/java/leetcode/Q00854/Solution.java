package leetcode.Q00854;

import java.util.*;

public class Solution {
    public int kSimilarity(String A, String B) {
        char[] chars = A.toCharArray();
        Set<String> cache = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(chars, 0));

        while (!q.isEmpty()) {
            Pair curPair = q.poll();

            int similarity = similarity(curPair.chars, B);

            if (similarity == -1) {
                return curPair.k;
            }

            for (int i = similarity + 1 ; i < A.length() ; ++i) {
                if (B.charAt(similarity) != curPair.chars[i]) {
                    continue;
                }

                char[] temp = curPair.chars.clone();
                swap(temp, i, similarity);
                String newChar = new String(temp);

                if (cache.contains(newChar)) {
                    continue;
                }

                cache.add(newChar);
                q.add(new Pair(temp, curPair.k + 1));
            }
        }

        return -1;
    }

    public int similarity(char[] chars, String b){
        for (int i = 0 ; i < chars.length ; ++i) {
            if (chars[i] != b.charAt(i)) {
                return i;
            }
        }

        return -1;
    }

    private void swap(char[] temp, int i, int j) {
        char t = temp[i];
        temp[i] = temp[j];
        temp[j] = t;
    }

    private static class Pair {
        private char[] chars;
        private int k;

        Pair(char[] chars, int k) {
            this.chars = chars;
            this.k = k;
        }
    }
}
