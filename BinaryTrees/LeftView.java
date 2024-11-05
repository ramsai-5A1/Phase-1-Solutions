

//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
       ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int index = 0; index < n; index++) {
                Node currNode = Q.poll();
                if (index == 0) {
                    result.add(currNode.data);
                }
                if (currNode.left != null) {
                    Q.add(currNode.left);
                }
                if (currNode.right != null) {
                    Q.add(currNode.right);
                }
            }
        }
        
        return result;
    }
}