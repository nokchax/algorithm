package leetcode.Q00105;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        return makeTree(preorder, 0, preorder.length, inorder);
    }

    private TreeNode makeTree(int[] preorder, int preS, int preE, int[] inorder) {
        TreeNode node = new TreeNode(preorder[preS]);
        //preS의 값이 inoreder 배열에서 idx 이전까지는 left, 이후는 right
        int leftEndValueIdx = getIdx(inorder, preorder[preS]);
        int leftEndIdx = getIdx(preorder, inorder[leftEndValueIdx]);

        if(preS + 1 < leftEndIdx + 1)
            node.left = makeTree(preorder, preS + 1, leftEndIdx + 1, inorder);
        if(leftEndIdx + 1 <  preE)
            node.right = makeTree(preorder, leftEndIdx + 1, preE, inorder);

        return node;
    }

    private int getIdx(int[] inorder, int target) {
        for(int i = 0 ; i < inorder.length ; ++i) {
            if (inorder[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
