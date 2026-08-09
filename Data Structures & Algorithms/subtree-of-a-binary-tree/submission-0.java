/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If subRoot is empty, it is always a subtree
        if (subRoot == null) {
            return true;
        }

        // If root is empty but subRoot is not
        if (root == null) {
            return false;
        }

        // Check if trees starting at current nodes are identical
        if (sameTree(root, subRoot)) {
            return true;
        }

        // Search in left and right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One is null or values are different
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Both left and right subtree must be same
        return sameTree(p.left, q.left) &&
               sameTree(p.right, q.right);
    }
}