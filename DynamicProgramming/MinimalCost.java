// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int n=arr.length;
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<n;i++){
            int minsteps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0) {
                    int jump=dp[i-j]+Math.abs(arr[i]-arr[i-j]);
                    minsteps=Math.min(jump,minsteps);
                }
                dp[i]=minsteps;
            }
        }return dp[n-1];
    }
}