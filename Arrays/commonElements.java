

// User function Template for Java

class commonElements {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        int n1=arr1.size();
        int n2=arr2.size();
        int n3=arr3.size();
        int i=0;
        int j=0;
        List<Integer> st=new ArrayList<>();
        while(i<n1 && j<n2){
            if(arr1.get(i)<arr2.get(j)){
                i++;
            }
            else if(arr1.get(i)>arr2.get(j)){
                j++;
            }
            else{
                st.add(arr1.get(i));
                i++;
                j++;
            }
        }
        int k=0;
        int s=0;
        List<Integer> ans=new ArrayList<>();
        while(s<st.size() && k<n3){
            if(st.get(s)<arr3.get(k)){
                s++;
            }
            else if(st.get(s)>arr3.get(k)){
                k++;
            }
            else{
                if(!ans.contains(st.get(s)))  ans.add(st.get(s));
                s++;
                k++;
            }
        }
        return ans;
    }
}




