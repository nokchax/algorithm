package test.t6.q1;

import test.t6.Tree;

public class Solution {
    public int solution(Tree root) {
        if (root == null) {
            return 0;
        }

        int numOfVisibleNode = 1;
        numOfVisibleNode += countVisible(root.x, root.l);
        numOfVisibleNode += countVisible(root.x, root.r);

        return numOfVisibleNode;
    }

    private int countVisible(int x, Tree node) {
        if (node == null) {
            return 0;
        }

        int numOfVisibleNode = x <= node.x ? 1 : 0;


        numOfVisibleNode += countVisible(Math.max(x, node.x), node.l);
        numOfVisibleNode += countVisible(Math.max(x, node.x), node.r);

        return numOfVisibleNode;
    }
}
