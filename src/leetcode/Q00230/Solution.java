package leetcode.Q00230;


import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode curNode = null;
        int idx = 0;

        while(idx != k) {
            curNode = stack.pop();

            if(curNode == null)
                continue;
            System.out.println(curNode.val + " " + idx);

            if(curNode.left == null) {
                idx++;
                stack.add(curNode.right);
            } else if(curNode.left != null) {
                stack.add(curNode.right);
                stack.add(curNode);
                stack.add(curNode.left);
                curNode.left = null;
                curNode.right = null;
            }
        }

        return curNode.val;
    }
}
