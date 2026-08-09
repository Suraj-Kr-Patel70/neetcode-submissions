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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both nodes are smaller than root
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are greater than root
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // They are on different sides,
            // or root is one of p/q
            else {
                return root;
            }
        }

        return null;
    }
}