

// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        if(arr.length==1)
        {
            return arr[0];
        }
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum>maxSum)
            {
                maxSum = sum;
            }
            if(sum<0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
}