package leetcode.Q01281;

class Solution {
    public int subtractProductAndSum(int n) {
        String numStr = String.valueOf(n);
        int product = 1;
        int sum = 0;
        for (char c : numStr.toCharArray()) {
            int x = c - '0';
            sum += x;
            product *= x;
        }
        
        return product - sum;
    }
}
