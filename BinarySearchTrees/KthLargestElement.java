

//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{
    private void findKthLargest(Node root, int[] store) {
        if (root == null) {
            return;
        }
        
        findKthLargest(root.right, store);
        store[0]--;
        if (store[0] == 0) {
            store[1] = root.data;
        }
        findKthLargest(root.left, store);
    }
    
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K) {
        int[] store = new int[2];
        store[0] = K;
        findKthLargest(root, store);
        return store[1];
    }
    
    
    
    
    
    
    
}