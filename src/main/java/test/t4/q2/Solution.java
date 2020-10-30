package test.t4.q2;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        int times = Integer.parseInt(SC.nextLine());
        int[] timeArr = getNInput(times);
        int tops = Integer.parseInt(SC.nextLine());
        int[] topArr = getNInput(tops);

        System.out.println(getNumOfServedRequest(timeArr, topArr));
    }

    private static int getNumOfServedRequest(int[] timeArr, int[] topArr) {
        Stack<Integer> request = new Stack<>();
        int servedRequestCount = 0;

        int timeIdx = 0;
        for (int top : topArr) {
            while (timeIdx < timeArr.length && timeArr[timeIdx] <= top) {
                request.push(timeArr[timeIdx++]);
            }

            int count = 5;
            while (!request.isEmpty() && count-- != 0) {
                request.pop();
                servedRequestCount++;
            }
        }

        return servedRequestCount;
    }

    private static int[] getNInput(int n) {
        return IntStream.range(0, n)
                .mapToObj(x -> SC.nextLine())
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
