package test.t9.q5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyCode {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long k = Long.parseLong(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Long> inputs = new LinkedList<>();

        String input;
        while ((input = br.readLine()) != null) {
            long num = Long.parseLong(input);
            inputs.add(num);
            pq.add(num);

            if (pq.size() == k) {
                sb.append(pq.peek()).append('\n');

                // remove
                pq.remove(inputs.poll());
            }
        }

        System.out.println(sb.toString());
    }
}
