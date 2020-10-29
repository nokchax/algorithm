package test.t3.q1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 답안 제출할때는 스캐너 사용하지 마세요 BufferedReader 를 사용하는 것 보다 느립니다.
        Scanner sc = new Scanner(System.in);
        List<Long> cache = init();

        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n ; ++i) {
            long num = Long.parseLong(sc.nextLine());
            int target = lowerBound(cache, num);

            sb.append(cache.get(target) == num ? cache.get(target + 1) : cache.get(target))
                    .append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int lowerBound(List<Long> cache, long target) {
        int start = 0;
        int end = cache.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (cache.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

    private static List<Long> init() {
        List<Long> cache = new ArrayList<>();
        cache.add(1L);
        cache.add(2L); // 1, 1 ,2 ,3 대신 1, 2, 3, 5 로 대체해서 1 보다 큰 피보나치 수열값을 찾을때 1이 아닌 2를 리턴하게 함.

        for (int i = 0 ; i <= 60 ; ++i) {
            long next = cache.get(cache.size() - 1) + cache.get(cache.size() - 2);
            cache.add(next);
        }

        return cache;
    }
}
