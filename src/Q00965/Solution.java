package Q00965;

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null)
            return false;

        return checkUni(root.left, root.val) && checkUni(root.right, root.val);
    }

    private boolean checkUni(TreeNode node, int val) {
        if(node == null)
            return true;

        return val == node.val && checkUni(node.left, node.val) && checkUni(node.right, node.val);
    }
}
