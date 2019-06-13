package leetcode.Q00094;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();


        if(root != null)
            inorder(root, result);


        return result;
    }

    public List<Integer> inorder(TreeNode node, List<Integer> result) {
        if(node == null)
            return  result;

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);

        return result;
    }
}

