package leetcode.Q00101;

import leetcode.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {

        return root == null || compareBoth(root.left, root.right);
    }

    private boolean compareBoth(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        else if(left != null && right == null) return false;
        else if(left == null && right != null) return false;
        else if (left.val != right.val) return false;

        return compareBoth(left.right, right.left) && compareBoth(left.left, right.right);
    }
}
