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

    private void postorderHelper(TreeNode root, List<Integer> result) {
       if (root == null) {
           return;
       }

       // step-1 (left)
       postorderHelper(root.left, result);

       // step-2 (right)
       postorderHelper(root.right, result);

       // step-3  (root)
       result.add(root.val);
   }

   public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       postorderHelper(root, result);
       return result;
   }
}