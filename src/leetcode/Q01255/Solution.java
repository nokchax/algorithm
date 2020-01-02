package leetcode.Q01255;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<String, Integer> cache = new HashMap<>();

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<Character, Integer> scores = createScoreMap(score);
        Map<Character, Integer> counts = createCountMap(letters);

        int max = 0;
        for(int i = 0 ; i < words.length ; ++i) {
            max = Math.max(max, backtracking(0, 0, words, scores, counts));
        }

        return max;
    }


    private int backtracking(int curSum, int putIdx, String[] words, Map<Character, Integer> scores, Map<Character, Integer> counts) {
        if(isNotValid(words[putIdx], counts)) {
            return curSum;
        }

        int max = 0;

        for(int i = putIdx + 1 ; i < words.length ; ++i) {
            //- counts;
            int[] tempCount = getCounts(words[putIdx]);
            calculateCounts(counts, tempCount, false);

            int score = calculateScore(words[putIdx], scores, counts);

            int tempScore = backtracking(curSum + score, i, words, scores, counts);
            max = Math.max(max, curSum + tempScore);

            //rollback counts;
            calculateCounts(counts, tempCount, true);
        }

        return max;
    }

    private void calculateCounts(Map<Character, Integer> counts, int[] tempCount, boolean isPlus) {
        for(int i = 0 ; i < 26 ; ++i) {
            int prevCount = counts.getOrDefault((char)('a' + i), 0);
            counts.put((char)('a' + i), prevCount + (isPlus ? (tempCount[i]) : (-tempCount[i])));
        }
    }

    private int[] getCounts(String word) {
        int[] count = new int[26];

        for(int i = 0 ; i < word.length() ; ++i) {
            count[word.charAt(i) - 'a']++;
        }

        return count;
    }

    private boolean isNotValid(String word, Map<Character, Integer> counts) {
        int[] count = new int[26];

        for(int i = 0 ; i < word.length() ; ++i) {
            count[word.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < 26 ; ++i) {
            if(counts.getOrDefault((char)(i + 'a'), 0) - count[i] < 0) {
                return false;
            }
        }

        return true;
    }

    private int calculateScore(String word, Map<Character, Integer> scores, Map<Character, Integer> counts) {
        if(cache.containsKey(word)) {
            return cache.get(word);
        }

        int[] countPerChar = new int[26];

        int score = 0;

        for(char c : word.toCharArray()) {
            int index = c - 'a';
            countPerChar[index]++;

            if(countPerChar[index] > counts.getOrDefault(c, 0)) {
                return 0;
            }

            score += scores.getOrDefault(c, 0);
        }

        cache.put(word, score);

        return score;
    }

    private Map<Character, Integer> createCountMap(char[] letters) {
        Map<Character, Integer> count = new HashMap<>();

        for(char c : letters) {
            int prevCount = count.getOrDefault(c, 0);
            count.put(c, prevCount + 1);
        }

        return count;
    }

    private Map<Character, Integer> createScoreMap(int[] score) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 'a' ; i <= 'z' ; ++i) {
            map.put((char)i, score[i - 'a']);
        }

        return map;
    }
}
