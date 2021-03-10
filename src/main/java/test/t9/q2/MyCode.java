package test.t9.q2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MyCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int lineCount = Integer.parseInt(inputs[0]);
        int size = Integer.parseInt(inputs[1]);
        StringBuilder sb = new StringBuilder();

        Queue<String> q = new LinkedList<>();
        for (int i = 0 ; i < lineCount ; ++i) {
            String[] cmds = br.readLine().split(" ");

            switch (cmds[0]) {
                case "OFFER":
                    sb.append(q.size() < size);
                    if (q.size() < size) {
                        q.add(cmds[1]);
                    }
                    break;
                case "TAKE":
                    sb.append(q.poll());
                    break;
                case "SIZE":
                    sb.append(q.size());
                    break;
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
