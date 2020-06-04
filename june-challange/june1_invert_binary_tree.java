//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        return invertTreeUtil(root);
    }

    public TreeNode invertTreeUtil(TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode temp = invertTreeUtil(root.right);
        root.right = invertTreeUtil(root.left);
        root.left = temp;

        return root;
    }
}