package test.t5.q3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int solution(int[] A) {
        int answer = Integer.MAX_VALUE;
        Set<Integer> size = new HashSet<>();

        for (int i : A) {
            size.add(i);
        }

        int front = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < A.length ; ++i) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }


            if (map.size() == size.size()) {
                // 최적화
                while (!map.isEmpty()) {
                    if (map.containsKey(A[front]) && map.get(A[front]) > 1) {
                        map.put(A[front], map.get(A[front]) - 1);
                        front++;
                    } else {
                        break;
                    }
                }
                answer = Math.min(i - front + 1, answer);
            }
        }

        return answer;
    }
}
