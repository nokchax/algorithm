package test.t5.q2;

import java.util.*;

public class Solution {
    public String[] solution(String[][] friends, String user_id) {
        Map<String, Set<String>> friendsList = new HashMap<>();
        Set<String> realFriends = friendsList.get(user_id);
        Map<String, Integer> mutualFriends = new HashMap<>();
        Set<String> notFriends = friendsList.keySet();
        notFriends.removeAll(realFriends);

        for (String realFriend : realFriends) {
            for (String mutualFriend : friendsList.get(realFriend)) {
                Integer count = mutualFriends.getOrDefault(mutualFriend, 0);
                mutualFriends.put(mutualFriend, count + 1);
            }
        }


        int count = 0;
        Set<String> answer = new HashSet<>();
        for (String mutualFriend : mutualFriends.keySet()) {
            int same = mutualFriends.get(mutualFriend);
            if (same < count) {
                continue;
            }

            if (same > count) {
                answer.clear();
            }

            answer.add(mutualFriend);
        }

        String[] answerList = answer.toArray(new String[]{});
        Arrays.sort(answerList);

        return answerList;
    }
}

