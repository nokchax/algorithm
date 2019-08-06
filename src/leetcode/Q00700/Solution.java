package leetcode.Q00700;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode node, int val) {
        if(node == null)
            return null;

        if(node.val == val)
            return node;

        return node.val < val ? dfs(node.right, val) : dfs(node.left, val);
    }
}
