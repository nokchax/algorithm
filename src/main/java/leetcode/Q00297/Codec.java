package leetcode.Q00297;

import leetcode.TreeNode;

import java.util.*;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        List<Integer> serializedList = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node == null) {
                serializedList.add(null);
                continue;
            }

            serializedList.add(node.val);

            q.add(node.left);
            q.add(node.right);
        }

        return Arrays.toString(serializedList.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> tokens = tokenize(data);

        if(tokens.isEmpty()) {
            return null;
        }

        TreeNode root = tokens.poll();
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);

        while(!tokens.isEmpty()) {
            TreeNode parent = parents.poll();

            TreeNode left = tokens.poll();
            TreeNode right = null;
            if(!tokens.isEmpty()) {
                right = tokens.poll();
            }

            parent.left = left;
            parent.right = right;

            if(left != null) {
                parents.add(left);
            }
            if(right != null) {
                parents.add(right);
            }
        }

        return root;
    }

    private Queue<TreeNode> tokenize(String data) {
        if(data.length() <= 2) {
            return new LinkedList<>();
        }

        data = data.substring(1, data.length() - 1);
        String[] token = data.split(",");

        Queue<TreeNode> tokens = new LinkedList<>();

        for(String t : token) {
            t = t.trim();
            if(t.equals("null")) {
                tokens.add(null);
            } else {
                tokens.add(new TreeNode(Integer.parseInt(t)));
            }
        }

        return tokens;
    }
}
