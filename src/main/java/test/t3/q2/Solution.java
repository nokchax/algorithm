package test.t3.q2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n ; ++i) {
            String input = sc.nextLine();
            sb.append(toAlphaNumeric(input)).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static String toAlphaNumeric(String input) {
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (isCharOrNum(c)) {
                sb.append(c);
            } else {
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }

        return sb.toString();
    }

    private static boolean isCharOrNum(char c) {
        return ('0' <= c && c <= '9') ||
                ('a' <= c && c <= 'z') ||
                ('A' <= c && c <= 'Z');
    }
}
