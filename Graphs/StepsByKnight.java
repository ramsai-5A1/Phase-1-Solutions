class Solution {
    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Convert 1-based indexing to 0-based indexing
        int kx = KnightPos[0] - 1;
        int ky = KnightPos[1] - 1;
        int tx = TargetPos[0] - 1;
        int ty = TargetPos[1] - 1;
        
        // If knight is already at target position
        if (kx == tx && ky == ty) return 0;
        
        // Possible movements for knight
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        // Visited array to keep track of visited positions
        boolean[][] visited = new boolean[N][N];
        
        // Add starting position to queue and mark it as visited
        queue.add(new int[]{kx, ky, 0}); // {x, y, steps}
        visited[kx][ky] = true;
        
        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];
            
            // Try all 8 possible movements
            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                // If next position is valid and not visited
                if (isValid(nextX, nextY, N) && !visited[nextX][nextY]) {
                    // If this is the target position
                    if (nextX == tx && nextY == ty) {
                        return steps + 1;
                    }
                    
                    // Add to queue and mark as visited
                    queue.add(new int[]{nextX, nextY, steps + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        return -1; // If target cannot be reached
    }
    
    // Helper function to check if position is valid
    private boolean isValid(int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}