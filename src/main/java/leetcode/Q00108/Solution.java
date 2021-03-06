package leetcode.Q00108;


import leetcode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return makeTreeNode(nums, 0, nums.length - 1);
    }

    public TreeNode makeTreeNode(int[] arr, int left, int right) {
        if(left > right)
            return null;
        int mid = (left + right + 1) / 2; // (left + right) / 2 also accepted

        TreeNode treeNode = new TreeNode(arr[mid]);
        treeNode.left = makeTreeNode(arr, left, mid - 1);
        treeNode.right = makeTreeNode(arr, mid + 1, right);

        return treeNode;
    }
}
