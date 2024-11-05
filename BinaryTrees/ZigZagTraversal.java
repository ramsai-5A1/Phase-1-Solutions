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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        boolean shouldReverse = false;
        
        while (!Q.isEmpty()) {
            int n = Q.size();
            List<Integer> subResult = new ArrayList<>();
            
            for (int index = 0; index < n; index++) {
                TreeNode currNode = Q.poll();
                subResult.add(currNode.val);
                
                if (currNode.left != null) {
                    Q.add(currNode.left);
                }
                
                if (currNode.right != null) {
                    Q.add(currNode.right);
                }
            }
        
            if (shouldReverse) {
                Collections.reverse(subResult);
            }
            result.add(subResult);
            shouldReverse = !shouldReverse;
        }
        return result;
    }
}