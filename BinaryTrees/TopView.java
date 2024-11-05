// User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, Integer> hMap = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair curr = q.remove();
            if(!hMap.containsKey(curr.hd)) hMap.put(curr.hd, curr.node.data);
            if(curr.node.left != null){
                q.add(new Pair(curr.node.left, curr.hd - 1));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.node.right, curr.hd + 1));
            }
        }
        
        for(Integer key: hMap.keySet()) res.add(hMap.get(key));
        return res;
    }
}