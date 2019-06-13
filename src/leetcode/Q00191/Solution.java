package leetcode.Q00191;

public class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        for(char c : Integer.toBinaryString(n).toCharArray()) {
            if(c == '1')
                count++;
        }

        return count;
    }
}
/*
public static int hammingWeight(int n) {
	int ones = 0;
    while(n!=0) {
    	ones = ones + (n & 1);
    	n = n>>>1;
    }
    return ones;
}
 */
