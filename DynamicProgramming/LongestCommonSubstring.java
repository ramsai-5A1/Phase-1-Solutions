class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n][m];
        int result = 0;
        
        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < m; index2++) {
                if (S1.charAt(index1) == S2.charAt(index2)) {
                    dp[index1][index2] = index1 > 0 && index2 > 0 ? dp[index1 - 1][index2 - 1] + 1 : 1;
                    result = Math.max(result, dp[index1][index2]);
                } else {
                    dp[index1][index2] = 0;
                }
            }
        }
        return result;
    }
}