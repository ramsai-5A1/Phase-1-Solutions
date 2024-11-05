


// =================  Recursion  =====================
// class Solution {
//     // Function to return max value that can be put in knapsack of capacity.
//     public static int fun(int cap , int val[], int wt[],int n){
        
//         if(n<0){
//             return 0;
//         }
        
//         //if(cap==0)
//         //take 
//          int take = Integer.MIN_VALUE;
//         if(wt[n]<=cap)
//         take = fun(cap-wt[n],val,wt,n-1) + val[n];
//         //not take
//         int nonTake = fun(cap,val,wt,n-1);
//         return Math.max(take,nonTake);
//     }
//     static int knapSack(int capacity, int val[], int wt[]) {
//         // code here
//         int n = val.length;
//         return fun(capacity,val,wt,n-1);
//     }
// }

//======================== Memoization ================

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    public static int fun(int cap , int val[], int wt[],int n,int dp[][]){
        
        if(n<0){
            return 0;
        }
        
        if(dp[n][cap]!=-1)return dp[n][cap];
        //take 
         int take = Integer.MIN_VALUE;
        if(wt[n]<=cap)
        take = fun(cap-wt[n],val,wt,n-1,dp) + val[n];
        //not take
        int nonTake = fun(cap,val,wt,n-1,dp);
        dp[n][cap] = Math.max(take,nonTake);
        return dp[n][cap];
    }
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        int n = val.length;
        int dp[][]  = new int[n+1][capacity+1];
        for(int i=0;i<n+1;i++)
        for(int j=0;j<capacity+1;j++)
        dp[i][j] = -1;
        return fun(capacity,val,wt,n-1,dp);
    }
}