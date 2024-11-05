

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        for(int node = 0; node < V; node++) {
            visited[node] = false;
        }
        Q.add(0);
        visited[0] = true;
        
        while(!Q.isEmpty()) {
            int curr = Q.remove();
            result.add(curr);
            
            for(int neighbour: adj.get(curr)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    Q.add(neighbour);
                }
            }
        }
        return result;
    }
}