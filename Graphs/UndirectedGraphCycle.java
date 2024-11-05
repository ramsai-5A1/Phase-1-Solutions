

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        
        // Since graph might be disconnected, we need to check for each component
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // DFS function that returns true if cycle is detected
    private boolean dfs(int vertex, int parent, boolean[] visited, 
                       ArrayList<ArrayList<Integer>> adj) {
        // Mark current vertex as visited
        visited[vertex] = true;
        
        // Visit all adjacent vertices
        for(Integer neighbor : adj.get(vertex)) {
            // If neighbor is not visited, recursively check for cycle
            if(!visited[neighbor]) {
                if(dfs(neighbor, vertex, visited, adj)) {
                    return true;
                }
            }
            // If neighbor is visited and not parent, we found a cycle
            // We check neighbor != parent because in undirected graph,
            // if vertex u is connected to v, then v is also connected to u
            else if(neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}