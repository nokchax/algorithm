package leetcode.Q00230;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> orderList = new ArrayList<>();
        dfs(root, orderList);

        return orderList.get(k - 1);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
