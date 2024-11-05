

class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int findLongestConseqSubseq(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int max = 0;
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == (prev+1) || arr[i] == prev){
                if(arr[i]==prev) continue;
                else count++;
            }
            else{
                max = Math.max(max, count);
                count = 1;
            }
            prev = arr[i];
        }
        max = Math.max(max, count);
        return max;
    }
}