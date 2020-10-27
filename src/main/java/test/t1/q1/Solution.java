package test.t1.q1;

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        long result = Result.solution(s);

        bw.write(String.valueOf(result));
        bw.newLine();

        br.close();
        bw.close();
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
