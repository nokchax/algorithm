package leetcode.Q00145;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        travel(root, answer);

        return answer;
    }

    private void travel(TreeNode node, List<Integer> answer) {
        if(node == null)
            return;

        travel(node.left, answer);
        travel(node.right, answer);
        answer.add(node.val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
