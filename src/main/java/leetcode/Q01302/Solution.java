package leetcode.Q01302;

import leetcode.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int deepestLeavesSum(TreeNode root) {
        Map<Integer, Integer> cache = new HashMap<>();
        dfs(root, 0, cache);

        int maxDepth = Collections.max(cache.keySet());

        return cache.get(maxDepth);
    }

    public void dfs(TreeNode node, int depth, Map<Integer, Integer> cache) {
        if (node == null) {
            return;
        }

        Integer value = cache.getOrDefault(depth, 0);
        cache.put(depth, value + node.val);

        dfs(node.left, depth + 1, cache);
        dfs(node.right, depth + 1, cache);
    }
}
