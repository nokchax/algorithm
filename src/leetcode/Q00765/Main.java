package leetcode.Q00765;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {1, 2, 3, 4};

        System.out.println(a);
        System.out.println(b);

        System.out.println("===============================");

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        System.out.println("===============================");

        System.out.println(a == b);
        System.out.println("===============================");

        System.out.println(a.equals(b));
        System.out.println(Arrays.equals(a, b));

        System.out.println("===============================");

        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;

        System.out.println(Arrays.toString(a));
    }
}
