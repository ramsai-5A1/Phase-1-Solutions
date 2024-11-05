

/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Array to mark visited vertices
        boolean[] visited = new boolean[V];
        // Array to track vertices in current DFS path
        boolean[] recStack = new boolean[V];
        
        // Check for cycle starting from each vertex
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(dfs(i, visited, recStack, adj)) {
                    return true;  // Cycle found
                }
            }
        }
        return false;  // No cycle found
    }
    
    private boolean dfs(int vertex, boolean[] visited, boolean[] recStack, 
                       ArrayList<ArrayList<Integer>> adj) {
        // Mark current vertex as visited and add to recursion stack
        visited[vertex] = true;
        recStack[vertex] = true;
        
        // Visit all adjacent vertices
        for(Integer neighbor : adj.get(vertex)) {
            // If not visited, recursively check for cycle
            if(!visited[neighbor]) {
                if(dfs(neighbor, visited, recStack, adj)) {
                    return true;
                }
            }
            // If vertex is in recursion stack, we found a cycle
            else if(recStack[neighbor]) {
                return true;
            }
        }
        
        // Remove vertex from recursion stack
        recStack[vertex] = false;
        return false;
    }
}