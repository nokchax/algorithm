package leetcode.Q01365;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] stack = new int[101];
        
        for (int i = 0 ; i < nums.length ; ++i) {
            stack[nums[i]]++;
        }
        
        for (int i = 1 ; i < 101 ; ++i) {
            stack[i] += stack[i - 1];
        }
        
        int[] answer = new int[nums.length];
        
        for (int i = 0 ; i < nums.length ; ++i) {
            int target =  nums[i] - 1;
            answer[i] = target < 0 ?  0 : stack[target];
        }
        
        return answer;
    }
}
