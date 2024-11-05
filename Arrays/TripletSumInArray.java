

// User function Template for Java

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean find3Numbers(int arr[], int n, int x) {

        Arrays.sort(arr);
        
        for(int i=0;i<n;i++) {
            int left = i+1;
            int right = n-1;
            
            while(left<right) {
                int currSum = arr[i]+arr[left]+arr[right];
                if(currSum == x) {
                    return true;
                }        
                else if(currSum<x) {
                    left++;
                }
                else {
                    right--;
                }
                
            }
        }
        return false;
    }
}