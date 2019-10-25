package leetcode.Q00765;

public class Solution {
    // count circular path
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        int[] position = new int[row.length];

        for (int i = 0; i < row.length; i++)
            position[row[i]] = i;

        int count = 0;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i])
                count++;

            int next = 2 * i;
            while (!visited[next / 2]) {
                visited[next / 2] = true;
                int pairVal = row[couplesNum(next)];
                next = position[couplesNum(pairVal)];
            }
        }

        return N - count;
    }

    private int couplesNum(int num) {
        return num % 2 == 0 ? num + 1 : num - 1;
    }
}
