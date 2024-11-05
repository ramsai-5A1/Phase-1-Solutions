class Solution {
    
    private int[] findNextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int index = n - 1; index >= 0; index--) {
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[index] = stack.peek();
            }
            stack.push(nums[index]);
        }
        return result;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGE = findNextGreaterElement(nums2);
        HashMap<Integer, Integer> store = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        for (int index = 0; index < n2; index++) {
            store.put(nums2[index], index);
        }
        
        int[] result = new int[n1];
        for (int index = 0; index < n1; index++) {
            int position = store.get(nums1[index]);
            result[index] = nextGE[position];
        }
        return result;
    }
}