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

    HashMap<Integer, Integer> map = new HashMap<>();
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder values and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {

        // No elements in this subtree
        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootIndex = map.get(rootValue);

        // Build left subtree
        root.left = build(preorder, left, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, right);

        return root;
    }
}