

// User function Template for Java

class Solution {
    private int helper(int[][] arr, int i, int prev, Integer[][] memo){
        if(i<0) return 0;
        if(memo[i][prev] != null) return memo[i][prev];
        int res = Integer.MIN_VALUE;
        for(int j=0; j<arr[0].length; j++){
            if(j != prev){
                    res = Math.max(res, arr[i][j] + helper(arr, i-1, j, memo));
            } 
        }
        memo[i][prev] = res;
        return res;
    }
    public int maximumPoints(int arr[][], int n) {
        // code here
        // Integer[][] memo = new Integer[n][4];
        // return helper(arr, n-1, 3, memo);
        
        int[][] dp = new int[n][3];
        
        for(int j=0; j<3; j++){
            dp[0][j] = arr[0][j];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<arr[0].length; j++){
                dp[i][0] = arr[i][0] + Math.max(dp[i-1][1], dp[i-1][2]); // Choosing task 0 at row i
            dp[i][1] = arr[i][1] + Math.max(dp[i-1][0], dp[i-1][2]); // Choosing task 1 at row i
            dp[i][2] = arr[i][2] + Math.max(dp[i-1][0], dp[i-1][1]); // Choosing task 2 at row i
            }
        }
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
    }
}