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

    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // step-1 (left)
        inorderHelper(root.left, result);

        // step-2  (root)
        result.add(root.val);

        // step-3 (right)
        inorderHelper(root.right, result);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }
}