package leetcode.Q00701;

import leetcode.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        return insert(root, val, null, false);
    }

    private TreeNode insert(TreeNode node, int val, TreeNode prev, boolean left) {
        if(node == null) {
            TreeNode newNode = new TreeNode(val);
            if(prev == null)
                return newNode;
            else {
                if(left)
                    prev.left = newNode;
                else
                    prev.right = newNode;
            }
            return prev;
        }

        if(node.val < val)
            insert(node.right, val, node, false);
        else
            insert(node.left, val, node, true);

        return node;
    }

}
