package test.t3.q3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Integer> aArr = toIntArr(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        List<Integer> bArr = toIntArr(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int aIdx = 0, bIdx = 0;
        while (--k > 0) {
            if (aArr.get(aIdx) <= bArr.get(bIdx)) {
                ++aIdx;
            } else {
                ++bIdx;
            }
        }

        System.out.println(Math.min(aArr.get(aIdx), bArr.get(bIdx)));
    }

    private static List<Integer> toIntArr(String input) {
        return Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
