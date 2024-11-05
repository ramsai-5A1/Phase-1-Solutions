




//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
         int n = arr.length;
        if(n < k) return -1;
        int low = Integer.MIN_VALUE, high=0;
        for(int i=0; i< n ; i++)
        {
        	low = Math.max(low, arr[i]);
        	high += arr[i];
        }
        while (low <= high) {
        	int mid = (low+high)/2;
        	int noStudents = countStudents(arr, mid);
        	if(noStudents > k) low = mid+1;
        	else high = mid-1;
		}
        return low;
    }
    
    private static int countStudents(int[] arr, int pages) {
		int students = 1;
		long pagesStudents=0;
		for(int i=0; i<arr.length; i++)
		{
			if(pagesStudents+ arr[i] <= pages)
				pagesStudents += arr[i];
			else
			{
				students++;
				pagesStudents = arr[i];
			}
			
		}
		return students;
		
	}
}