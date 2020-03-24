package leetcode.Q01022;

import leetcode.TreeNode;

public class Solution {
    int total = 0;
    public int sumRootToLeaf(TreeNode node) {

        dfs(node, new StringBuilder());

        return total;
    }

    private void dfs(TreeNode node, StringBuilder temp) {
        if(node == null)
            return;

        temp.append(node.val);

        if(node.left == null && node.right == null) {
            total += calculate(temp.toString());
        } else {
            dfs(node.left, temp);
            dfs(node.right, temp);
        }

        temp.deleteCharAt(temp.length() - 1);
    }
    private int calculate(String binary) {
        int x = 1;
        int sum = 0;

        for(int i = binary.length() - 1 ; i >= 0 ; --i) {
            if(binary.charAt(i) == '1')
                sum += x;
            x *= 2;
        }

        return sum;
    }
}
