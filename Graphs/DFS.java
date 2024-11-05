

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        result.add(node);
        visited[node] = true;
        
        for(int neighbour: adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited, result);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;
            
        dfs(0, adj, visited, result);
        return result;
    }
}