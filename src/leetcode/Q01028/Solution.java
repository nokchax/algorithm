package leetcode.Q01028;

import java.util.*;

public class Solution {

    public TreeNode recoverFromPreorder(String s) {
        Queue<String> bars = new LinkedList<>(Arrays.asList(s.split("\\d+")));
        Queue<String> nums = new LinkedList<>(Arrays.asList(s.split("(-)+")));

        System.out.println(Arrays.toString(s.split("\\d+")));
        System.out.println(Arrays.toString(s.split("(-)+")));

        return makeNode(bars, nums, 0);
    }

    private TreeNode makeNode(Queue<String> bars, Queue<String> nums, int depth) {
        if(!checkBarCount(bars.peek(), nums, depth))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(nums.poll()));
        bars.poll();

        node.left = makeNode(bars, nums,depth + 1);
        node.right = makeNode(bars, nums, depth + 1);

        return node;
    }

    private boolean checkBarCount(String bar, Queue<String> nums, int depth) {
        if(bar == null) return !nums.isEmpty();
        return bar.length() == depth;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }
}
