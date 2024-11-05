class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> store = new HashMap<>();
        int n = nums.length;
        for(int index = 0; index < n; index++) {
            if (store.containsKey(target - nums[index])) {
                int[] result = {store.get(target - nums[index]), index};
                return result;
            }
            store.put(nums[index], index);
        }
        int[] result = {-1, -1};
        return result;
    }
}