package leetcode.Q01008;

import leetcode.TreeNode;

public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {

        return makeNode(preorder, 0, preorder.length);
    }

    private TreeNode makeNode(int[] preorder, int start, int end) {
        if(start >= end)
            return null;

        TreeNode node = new TreeNode(preorder[start]);

        int limit = getLimit(preorder, start);

        node.left = makeNode(preorder, start + 1, limit);
        node.right = makeNode(preorder, limit, end);

        return node;
    }

    private int getLimit(int[] preorder, int start) {
        int standard = preorder[start];

        for(int i = start + 1 ; i < preorder.length ; ++i)
            if(preorder[i] > standard)
                return i;

        return preorder.length;
    }
}
