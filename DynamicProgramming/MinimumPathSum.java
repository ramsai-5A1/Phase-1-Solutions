class Solution {

    private int topDown(int row, int col, int[][] grid, int m, int n, int[][] cache) {
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        } else if (row >= m || col >= n) {
            return (int) 1e9;
        } else if (cache[row][col] != -1) {
            return cache[row][col];
        }

        int bottom = topDown(row + 1, col, grid, m, n, cache);
        int right = topDown(row, col + 1, grid, m, n, cache);
        int result = grid[row][col];
        int mn = Math.min(bottom, right);
        if (mn != 1e9) {
            result += mn;
        }
        cache[row][col] = result;
        return result;
    }

    private int bottomUp(int[][] grid, int m, int n) {
        int[][] cache = new int[m][n];
        cache[m - 1][n - 1] = grid[m - 1][n - 1];

        for (int col = n - 2; col >= 0; col--) {
            cache[m - 1][col] = cache[m - 1][col + 1] + grid[m - 1][col];
        }

        for (int row = m - 2; row >= 0; row--) {
            cache[row][n - 1] = cache[row + 1][n - 1] + grid[row][n - 1];
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                cache[row][col] = Math.min(cache[row + 1][col], cache[row][col + 1]) + grid[row][col];
            }
        }
        return cache[0][0];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        //return topDown(0, 0, grid, m, n, cache);
        return bottomUp(grid, m, n);
    }
}