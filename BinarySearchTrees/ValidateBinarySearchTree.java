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

    private boolean helper(TreeNode root, long mn, long mx) {
        if (root == null) {
            return true;
        } else if (root.val <= mn || root.val >= mx) {
            return false;
        }

        return helper(root.left, mn, root.val) && helper(root.right, root.val, mx);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}