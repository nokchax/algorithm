package test.t2.q1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String y = sc.nextLine();

        System.out.println(solution(x, y));
    }

    public static String solution(String x, String y) {
        String one = merge(x, y);
        String theOther = merge(y, x);

        if (one.length() == theOther.length()) {
            return one.compareTo(theOther) < 0 ? one : theOther;
        }

        return one.length() < theOther.length() ?
                one : theOther;
    }

    public static String merge(String x, String y) {
        int idx = 0;
        int startIdx = x.length() < y.length() ? 0 : x.length() - y.length();

        for (int i = startIdx ; i < x.length() ; ++i) {
            if (x.charAt(i) == y.charAt(idx)) {
                idx++;
            } else {
                idx = 0;
            }
        }

        return x + y.substring(idx);
    }
}
