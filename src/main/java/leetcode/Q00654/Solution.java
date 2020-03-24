package leetcode.Q00654;

import leetcode.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return growTree(nums, 0, nums.length);
    }

    // to is exclusive
    private TreeNode growTree(int[] nums, int from, int to) {
        if(from >= to)
            return null;

        int maximumIdx = getMaximumIdx(nums, from, to);
        TreeNode treeNode = new TreeNode(nums[maximumIdx]);

        treeNode.left = growTree(nums, from, maximumIdx);
        treeNode.right = growTree(nums, maximumIdx + 1, to);

        return treeNode;
    }

    private int getMaximumIdx(int[] nums, int from, int to) {
        int maximumIdx = from;

        for(int i = from ; i < to ; ++i)
            if(nums[maximumIdx] < nums[i])
                maximumIdx = i;

        return maximumIdx;
    }
}
