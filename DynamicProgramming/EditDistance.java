class Solution {

    private int topDown(String word1, int index1, int n1, String word2, int index2, int n2, int[][] cache) {
        if (index1 == n1) {
            return n2 - index2;
        } else if (index2 == n2) {
            return n1 - index1;
        } else if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }
        int result = 0;
        if (word1.charAt(index1) == word2.charAt(index2)) {
            result = topDown(word1, index1 + 1, n1, word2, index2 + 1, n2, cache);
        } else {
            int insertChar = topDown(word1, index1, n1, word2, index2 + 1, n2, cache);
            int deleteChar = topDown(word1, index1 + 1, n1, word2, index2, n2, cache);
            int replaceChar = topDown(word1, index1 + 1, n1, word2, index2 + 1, n2, cache);
            result = 1 + Math.min(Math.min(insertChar, deleteChar), replaceChar);
        }
        cache[index1][index2] = result;
        return result;
    }

    private int bottomUp(String word1, int n1, String word2, int n2, int[][] cache) {
        for (int index2 = 0; index2 <= n2; index2++) {
            cache[n1][index2] = n2 - index2;
        }
        for (int index1 = 0; index1 <= n1; index1++) {
            cache[index1][n2] = n1 - index1;
        }
        for (int index1 = n1 - 1; index1 >= 0; index1--) {
            for (int index2 = n2 - 1; index2 >= 0; index2--) {
                int result = 0;
                if (word1.charAt(index1) == word2.charAt(index2)) {
                    result = cache[index1 + 1][index2 + 1];
                } else {
                    int insertChar = cache[index1][index2 + 1];
                    int deleteChar = cache[index1 + 1][index2];
                    int replaceChar = cache[index1 + 1][index2 + 1];
                    result = 1 + Math.min(Math.min(insertChar, deleteChar), replaceChar);
                }
                cache[index1][index2] = result;
            }
        }
        return cache[0][0];
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] cache = new int[n1 + 1][n2 + 1];
        for (int[] row: cache) {
            Arrays.fill(row, 0);
        }
        //return topDown(word1, 0, n1, word2, 0, n2, cache);
        return bottomUp(word1, n1, word2, n2, cache);
    }
}