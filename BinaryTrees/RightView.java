class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        ArrayList<Integer> res=new ArrayList<>();
        rightadd(root,res,0);
        return res;
    }
    public static void rightadd(Node node,ArrayList<Integer>res, int depth){
        if(node==null){
            return;
        }
        if(depth==res.size()){
            res.add(node.data);
        }
        
        rightadd(node.right,res,depth+1);
        rightadd(node.left,res,depth+1);
        
    }
}