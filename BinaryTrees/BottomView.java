

//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList <Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,Integer> map=new TreeMap<>();
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Pair p=q.peek();
                Node curr=p.f;
                int level=p.s;
                q.remove();
                map.put(level,curr.data);
                if(curr.left!=null){
                    q.add(new Pair(curr.left,level-1));
                }
                if(curr.right!=null){
                    q.add(new Pair(curr.right,level+1));
                }
            }
        }
        for(Integer val:map.values()){
            res.add(val);
        }
        return res;
    }
}
class Pair{
    Node f;
    int s;
    public Pair(Node f,int s){
        this.f=f;
        this.s=s;
    }
}