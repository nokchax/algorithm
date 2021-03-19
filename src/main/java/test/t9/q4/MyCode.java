package test.t9.q4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyCode {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineCount = Integer.parseInt(br.readLine());
        int count = 0;

        boolean[][] map = new boolean[lineCount][lineCount];


        while(count < lineCount) {
            count++;
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            map[y][x] = true;
        }

        for (int i = 0 ; i < lineCount ; ++i) {
            // check circular
            boolean[] visited = new boolean[lineCount];

            for (int next = 0 ; next < lineCount ; ++next) {
                if (checkCircular(map, visited, next)) {
                    System.out.println("true");
                    return;
                }
            }
        }

        System.out.println("false");
    }

    public static boolean checkCircular(boolean[][] map, boolean[] visited, int cur) {
        if (visited[cur]) {
            return true;
        }

        visited[cur] = true;
        for (int next = 0 ; next < visited.length ; ++next) {
            if (map[cur][next] && checkCircular(map, visited, next)) {
                return true;
            }
        }
        visited[cur] = false;

        return false;
    }
}
