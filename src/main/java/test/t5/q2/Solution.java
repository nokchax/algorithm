package test.t5.q2;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public int solution(int[] A, int K) {
        int limit = A.length - K;
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> temp = new LinkedList<>();
        
        for (int i = 0 ; i < A.length ; ++i) {
            //i번째 기준으로 k개 만큼을 제외함.
            if (i < K) {
                temp.addLast(i);
            } else {
                int targetNum = A[i];

                // maxQ 초기화
                while(!maxQ.isEmpty() && A[maxQ.peekLast()] < targetNum) {
                    maxQ.pollLast();
                }
                maxQ.addLast(i);

                // minQ 초기화
                while(!minQ.isEmpty() && A[minQ.peekLast()] > targetNum) {
                    maxQ.pollLast();
                }
                minQ.addLast(i);
            }
        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0 ; i < limit ; ++i) {
            // temp의 제일 앞


        }
        
        
        return 0;
    }
}
