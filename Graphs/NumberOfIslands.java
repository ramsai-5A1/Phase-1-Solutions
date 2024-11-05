class Solution {
    
    private void markAllAdjacentOnes(int row, int col, char[][] grid, int m, int n) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        markAllAdjacentOnes(row - 1, col, grid, m, n);
        markAllAdjacentOnes(row + 1, col, grid, m, n);
        markAllAdjacentOnes(row, col - 1, grid, m, n);
        markAllAdjacentOnes(row, col + 1, grid, m, n);
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandsCount = 0;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1') {
                    islandsCount++;
                    markAllAdjacentOnes(row, col, grid, m, n);
                }
            }
        }
        
        return islandsCount;
    }
}