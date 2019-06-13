package leetcode.Q00102;


import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return Collections.emptyList();

        List<TreeNode> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        list.add(root);

        while(!list.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();

            for(TreeNode cur : list) {
                level.add(cur.val);

                if(cur.left != null)
                    nextLevel.add(cur.left);
                if(cur.right != null)
                    nextLevel.add(cur.right);
            }

            answer.add(level);
            list = nextLevel;
        }

        return answer;
    }
}
