package test.t1.q1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        long result = Result.solution(s);
        System.out.println(result);
    }
}

class Result {
    public static final int MAX = ('Z' - 'A');
    public static final int HALF = MAX / 2;
    public static long solution(String s) {
        s = s.toUpperCase();

        char curPosition = 'A';
        long answer = 0L;

        for (char nextPosition : s.toCharArray()) {
            answer += getShortestPath(curPosition, nextPosition);
            curPosition = nextPosition;
        }

        return answer;
    }

    private static long getShortestPath(char curPosition, char nextPosition) {
        int distance = Math.abs(nextPosition - curPosition);

        return distance <= HALF ? distance : MAX - distance + 1;
    }
}
