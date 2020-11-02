package test.t4.q3;

import java.util.*;

public class Solution {
    /*
        Array 과 SubArray 크기 k 가 주어졌을때 구간 최소값중 최대값을 구하는 문제
        ex) Array 사이즈가 10 이고, k가 3이면

        Array[0] Array[1] Array[2] = 최소값
        Array[1] Array[2] Array[3] = 최소값
        ...
        Array[7] Array[8] Array[9] = 최소값

        최소값 중 최대값 구하기
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(sc.nextLine());

        System.out.println(slidingWindow(array, k));
    }

    private static int slidingWindow(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < k ; ++i) {
            pq.add(array[i]);
        }

        int max = pq.peek();

        for (int i = k ; i < array.length ; ++i) {
            pq.remove(array[i - k]);
            pq.add(array[i]);
            max = Math.max(max, pq.peek());
        }

        return max;
    }

    private static int usingStack(int[] array, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < array.length ; ++i) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k - 1) { //k개 범위를 넘어가는 원소 제거
                deque.pollFirst();
            }

            while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) { // 현재 값보다 큰 값 제거
                deque.pollLast();
            }

            deque.addLast(i);

            if (i > k - 1 && !deque.isEmpty()) {
                max = Math.max(max, array[deque.peekFirst()]);
            }
        }

        return max;
    }
}
