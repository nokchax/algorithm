package Q00108;

import java.util.Arrays;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        return makeTreeNode(nums);
    }

    public TreeNode makeTreeNode(int[] sub) {
        if(sub.length < 1)
            return null;

        TreeNode treeNode = new TreeNode(sub[sub.length / 2]);
        treeNode.left = makeTreeNode(Arrays.copyOfRange(sub, 0, sub.length / 2));
        treeNode.right = makeTreeNode(Arrays.copyOfRange(sub, sub.length / 2 + 1, sub.length));

        return treeNode;
    }
}
