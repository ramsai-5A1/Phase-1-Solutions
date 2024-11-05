

// User function Template for Java

class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        
// Mistake 1: List is an interface, you can't instantiate it directly. Use ArrayList instead.

        // List<List<Integer>> ls = new ArrayList<List<Integer>>(V+1);   // Incorrect instantiation

// When you create the ArrayList<List<Integer>> adj = new ArrayList<List<Integer>>(V);, you are only creating the outer list. However, the inner lists (which will hold the vertices adjacent to each vertex) are not initialized yet. You need to initialize each inner list explicitly before you can add any elements to it.
        List<List<Integer>> adj = new ArrayList<>(V);

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        int m = edges.length;
        for(int i=0; i<m; i++){
// Mistake 2: You are accessing the 2D array incorrectly. 'edges[0][i]' and 'edges[i][0]' are wrong.
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}