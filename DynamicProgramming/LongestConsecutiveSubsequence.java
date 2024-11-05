class Solution {


    private int solveIt(String text1, int index1, int n, String text2, int index2, int m, int[][] cache) {
        if (index1 == n || index2 == m) {
            return 0;
        } else if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        } else if (text1.charAt(index1) == text2.charAt(index2)) {
            cache[index1][index2] = 1 + solveIt(text1, index1 + 1, n, text2, index2 + 1, m, cache);
            return cache[index1][index2];
        }

        int choice1 = solveIt(text1, index1 + 1, n, text2, index2, m, cache);
        int choice2 = solveIt(text1, index1, n, text2, index2 + 1, m, cache);
        cache[index1][index2] = Math.max(choice1, choice2);
        return cache[index1][index2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] cache = new int[n + 1][m + 1];
        // for (int row = 0; row < n; row++) {
        //     Arrays.fill(cache[row], -1);
        // }
        // return solveIt(text1, 0, n, text2, 0, m, cache);

        for (int index1 = n - 1; index1 >= 0; index1--) {
            for (int index2 = m - 1; index2 >= 0; index2--) {
                if (text1.charAt(index1) == text2.charAt(index2)) {
                    cache[index1][index2] = 1 + cache[index1 + 1][index2 + 1];
                } else {
                    int choice1 = cache[index1 + 1][index2];
                    int choice2 = cache[index1][index2 + 1];
                    cache[index1][index2] = Math.max(choice1, choice2);
                }
            }
        }
        return cache[0][0];
    }
}