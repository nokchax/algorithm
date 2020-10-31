package test.t5.q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] solution(String[] cards, String[] words) {
        List<String> answer = new ArrayList<>();
        Map<Character, int[]> cardMap = initCardMap(cards);

        for (String word : words) {
            if (isCreatable(cardMap, word)) {
                answer.add(word);
            }
        }


        if (answer.isEmpty()) {
            answer.add("-1");
        }

        return answer.toArray(new String[]{});
    }

    private static Map<Character, int[]> initCardMap(String[] cards) {
        Map<Character, int[]> cardMap = new HashMap<>();
        int line = -1;
        for (String card : cards) {
            ++line;
            for (char c : card.toCharArray()) {
                int[] prev = new int[]{line, 0};
                if (cardMap.containsKey(c)) {
                    prev = cardMap.get(c);
                }

                cardMap.put(c, new int[]{prev[0], prev[1] + 1}); //0 line, 1 count
            }
        }

        return cardMap;
    }

    private static boolean isCreatable(Map<Character, int[]> cardMap, String word) {
        boolean[] used = new boolean[3];
        Map<Character, Integer> wordCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            Integer count = wordCount.getOrDefault(c, 0);
            wordCount.put(c, count + 1);
        }

        for (char c : wordCount.keySet()) {
            if (!cardMap.containsKey(c)) {
                return false;
            }

            int[] info = cardMap.get(c);
            if (info[1] < wordCount.get(c)) {
                return false;
            }

            used[info[0]] = true;
        }

        return used[0] && used[1] && used[2];
    }
}
