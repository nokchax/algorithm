package leetcode.Q00103;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);

        return list;
    }

    public void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if(node == null)
            return;

        if(list.size() <= level) {
            list.add(new ArrayList<>());
        }
        if(level % 2 == 0)
            list.get(level).add(node.val);
        else
            list.get(level).add(0, node.val);

        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}
