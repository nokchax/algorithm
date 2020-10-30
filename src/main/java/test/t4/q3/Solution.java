package test.t4.q3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

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
}
