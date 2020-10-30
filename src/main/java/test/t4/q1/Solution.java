package test.t4.q1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    /*
        Array가 주어졌을때 왼쪽 합과 오른쪽 합을 비교했을때 왼쪽 합이 큰 것의 개수를 구하라

        ex) array length : 10 일때
        index 0의 합, index 1~9의 합
        index 0~1의 합, index 2~9의 합
        ...
        ...

        왼쪽합이 더 크면 개수++
        return 개수
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(countLeftBigCase(array));
    }

    private static int countLeftBigCase(int[] array) {
        int answer = 0;
        int rightSum = Arrays.stream(array).sum();
        int leftSum = 0;

        for (int i = 0 ; i < array.length - 1 ; ++i) {
            leftSum += array[i];
            rightSum -= array[i];

            if (leftSum > rightSum) {
                answer++;
            }
        }

        return answer;
    }
}
