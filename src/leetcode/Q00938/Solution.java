package leetcode.Q00938;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return getSum(root, L, R);
    }

    private int getSum(TreeNode node, int L, int R) {
        if(node == null)
            return 0;

        if(node.val < L)
            return getSum(node.right, L, R);
        else if(node.val > R)
            return getSum(node.left, L, R);
        else
            return node.val + getSum(node.left, L, R) + getSum(node.right, L, R);
    }
}
