

// User function Template for Java
class Solution {
    public static boolean canweplace(int[] stalls,int s,int k){
        int cntcow = 1;
        int last = stalls[0];
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-last >= s){
                cntcow++;
                last=stalls[i];
            }
            if(cntcow >= k) return true;
        }
        return false;
    }
    public static int aggresiveCows(int[] stalls, int k) {
       Arrays.sort(stalls);
       int n = stalls.length;
       int low = 1;
       int high = stalls[n-1] - stalls[0];
       int ans=0;
       while(low <= high){
           int mid = (low+high)/2;
           if(canweplace(stalls,mid,k) == true){
               ans = mid;
               low = mid+1;
           }
           else{
               high = mid-1;
           }
       }
       return ans;
    }
}