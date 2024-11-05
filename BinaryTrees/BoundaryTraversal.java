

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    void addLeafNodes(Node root,ArrayList<Integer> boundary)
    {
        if(root==null) return;
        if(root.left==null && root.right==null)
        boundary.add(root.data);
        addLeafNodes(root.left,boundary);
        addLeafNodes(root.right,boundary);
    }
    boolean isLeaf(Node root)
    {
        if(root==null) return false;
        if(root.left==null && root.right==null)
        return true;
        else
        return false;
    }
	ArrayList<Integer> boundary(Node root)
	{
	    ArrayList<Integer> boundary = new ArrayList<>();
	    if(root==null) return boundary;
	    boundary.add(root.data);
	    // Add the left part excluding leaf nodes
	    Node temp = root.left;
	    while(temp!=null)
	    {
	        if(!isLeaf(temp))
	        boundary.add(temp.data);
	        temp = temp.left!=null ? temp.left : temp.right; 
	    }
	    // Add the leaf nodes using inorder (excluding the root)
	    addLeafNodes(root.left,boundary);
	    addLeafNodes(root.right,boundary);
	    // Add right part using stack excluding leaf nodes
	    temp = root.right;
	    Stack<Node> stack = new Stack<>();
	    while(temp!=null)
	    {
	        stack.push(temp);
	        temp = temp.right!=null ? temp.right : temp.left; 
	    }
	    while(!stack.isEmpty())
	    {
	        Node current = stack.pop();
	        if(!isLeaf(current))
	        boundary.add(current.data);
	    }
	    return boundary;
	}
}