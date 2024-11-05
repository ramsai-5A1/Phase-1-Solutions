class Solution {

    private int topDown(int row, int col, int m, int n, int[][] cache) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        } else if (row >= m || col >= n) {
            return 0;
        } else if (cache[row][col] != -1) {
            return cache[row][col];
        }

        int result = 0;
        result = result + topDown(row + 1, col, m, n, cache);
        result = result + topDown(row, col + 1, m, n, cache);
        cache[row][col] = result;
        return result;
    }

    private int bottomUp(int m, int n) {
        int[][] cache = new int[m][n];

        for (int row = 0; row < m; row++) {
            cache[row][n - 1] = 1;
        }

        for (int col = 0; col < n; col++) {
            cache[m - 1][col] = 1;
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                cache[row][col] = cache[row + 1][col] + cache[row][col + 1];
            }
        }
        return cache[0][0];
    }

    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        // return topDown(0, 0, m, n, cache);
        return bottomUp(m, n);
    }
}