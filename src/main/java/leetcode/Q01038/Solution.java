package leetcode.Q01038;

import leetcode.TreeNode;

public class Solution {
    public TreeNode bstToGst(TreeNode root) {

        calc(root, 0);
        return root;
    }

    private int calc(TreeNode node, int val) {
        if(node == null)
            return val;

        node.val = node.val + calc(node.right, val);
        return calc(node.left, node.val);
    }
}
