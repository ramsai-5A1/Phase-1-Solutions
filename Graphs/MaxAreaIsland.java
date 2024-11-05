

class Pair {
    public int row;
    public int col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    
    private int findOnesCountUsingBFS(int row, int col, int[][] grid, boolean[][] visited, int n, int m) {
        visited[row][col] = true;
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(row, col));
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int onesCount = 0;
        
        while (!Q.isEmpty()) {
            Pair curr = Q.poll();
            onesCount++;
            
            for(int[] direction: directions) {
                int newRow = curr.row + direction[0];
                int newCol = curr.col + direction[1];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m && grid[newRow][newCol] == 1 && visited[newRow][newCol] == false) {
                    visited[newRow][newCol] = true;
                    Q.add(new Pair(newRow, newCol));
                }
            }
        }
        return onesCount;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean[][] visited = new boolean[n][m];
        
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1 && visited[row][col] == false) {
                    int onesCount = findOnesCountUsingBFS(row, col, grid, visited, n, m);
                    result = Math.max(result, onesCount);
                }
            }
        }
        return result;
    }
}