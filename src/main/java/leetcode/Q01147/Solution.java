package leetcode.Q01147;

import java.util.*;

public class Solution {
    int length;
    int backIdx;

    public int longestDecomposition(String text) { // 1 <= text <= 1000
        length = text.length() / 2;
        backIdx = text.length();
        int count = 0;

        Queue<Character> q = new LinkedList<>();

        for(int startIdx = 0 ; startIdx < length ; ++startIdx) {
            char targetChar = text.charAt(startIdx);
            q.add(targetChar);

            if(!q.isEmpty() && q.peek() == text.charAt(backIdx - 1 - startIdx)) {
                // stack 과 비교
                if(isSame((LinkedList<Character>) ((LinkedList<Character>) q).clone(), startIdx, text)) {
                    q.clear();
                    count += 2;
                }
            }
        }

        if(!q.isEmpty()) {
            count++;
        } else {
            count += text.length() % 2 == 0 ? 0 : 1;
        }

        return count;
    }

    private boolean isSame(LinkedList<Character> q, int startIdx, String text) {
        int backStartIdx = backIdx - 1 - startIdx;

        for(int i = 0 ; i < q.size() ; ++i) {
            char c = q.get(i);

            if(c != text.charAt(backStartIdx + i)) {
                return false;
            }
        }

        return true;
    }
}
