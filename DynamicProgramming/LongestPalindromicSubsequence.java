class Solution {

    private int topDown(String s1, int index1, int n, String s2, int index2, int[][] cache) {
        if (index1 == n || index2 == n) {
            return 0;
        } else if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }

        int result = 0;
        if (s1.charAt(index1) == s2.charAt(index2)) {
            result = 1 + topDown(s1, index1 + 1, n, s2, index2 + 1, cache);
        } else {
            int option1 = topDown(s1, index1 + 1, n, s2, index2, cache);
            int option2 = topDown(s1, index1, n, s2, index2 + 1, cache);
            result = Math.max(option1, option2);
        }
        cache[index1][index2] = result;
        return result;
    }

    private int topDown2(String s, int index1, int n, int index2, int[][] cache) {
        if (index1 == n ||index2 == 0) {
            return 0;
        } else if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }

        int result = 0;
        if (s.charAt(index1) == s.charAt(index2 - 1)) {
            result = 1 + topDown2(s, index1 + 1, n, index2 - 1, cache);
        } else {
            int option1 = topDown2(s, index1 + 1, n, index2, cache);
            int option2 = topDown2(s, index1, n, index2 - 1, cache);
            result = Math.max(option1, option2);
        }
        cache[index1][index2] = result;
        return result;
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] cache = new int[n][n + 1];
        for (int[] row: cache) {
            Arrays.fill(row, -1);
        }
        // StringBuilder s2 = new StringBuilder();
        // s2.append(s);
        // s2.reverse();
        // return topDown(s, 0, n, s2.toString(), 0, cache);
        return topDown2(s, 0, n, n, cache);
    }
}