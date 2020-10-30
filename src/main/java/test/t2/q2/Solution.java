package test.t2.q2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());

        System.out.println(solution(num));
    }

    private static boolean solution(int num) {
        String numStr = String.valueOf(num);

        for (int i = 0 ; i < numStr.length() / 2 ; ++i) {
            if (numStr.charAt(i) != numStr.charAt(numStr.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
