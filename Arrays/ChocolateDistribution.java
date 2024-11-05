

// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int i=0;
        int max=Integer.MAX_VALUE;
        while(i<=arr.size()-m){
            int temp=arr.get(i+m-1)-arr.get(i);
          
            if(max > temp){
                max=temp;
            }
            //System.out.println("max"+ max);
            i++;
        }
        return max;
    }
}