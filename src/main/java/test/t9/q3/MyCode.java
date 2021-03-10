package test.t9.q3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyCode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];

        for (int i = 0 ; i < inputs.length ; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int targetNum = Integer.parseInt(br.readLine());
        int startIdx = Arrays.binarySearch(nums, targetNum);

        for (int index = (startIdx == -1 ? nums.length - 1 : startIdx) ; index > 0 ; --index) {
            int pairNum = targetNum - nums[index];
            if (Arrays.binarySearch(nums, pairNum) != -1) {
                System.out.println(pairNum + " " + nums[index]);
                return;
            }
        }

        System.out.println("-1");
    }
}
