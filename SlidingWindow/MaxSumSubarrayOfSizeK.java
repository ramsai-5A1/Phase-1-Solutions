

// User function Template for Java

class Solution {
    public long maximumSumSubarray(int[] arr, int k) {
        int len = arr.length;
        int curr_sum = 0 ;
        for(int i = 0 ; i < k ; i++){
            curr_sum += arr[i];
            
        }
        int max_sum = curr_sum ;
        
        for(int i = k ; i < len ; i++){
            curr_sum  = curr_sum + arr[i] - arr[i-k];
            max_sum = Math.max(max_sum , curr_sum);
        }
        return max_sum;
    }
}