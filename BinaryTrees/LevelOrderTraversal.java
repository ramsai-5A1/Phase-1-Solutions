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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();;
        if (root == null) {
            return result;
        }

        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int n = Q.size();
            for (int index = 0; index < n; index++) {
                TreeNode currNode = Q.poll();
                subResult.add(currNode.val);

                if (currNode.left != null) {
                    Q.offer(currNode.left);
                }

                if (currNode.right != null) {
                    Q.offer(currNode.right);
                }
            }
            result.add(subResult);
        }
        return result;  
    }
}