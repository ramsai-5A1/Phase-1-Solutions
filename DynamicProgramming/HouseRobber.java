class Solution {
    
    private int helper(int currentHouse, int totalHouses, int[] nums, int[] alreadyCalculated) {
        if (currentHouse >= totalHouses) {
            return 0;
        } 
        if (alreadyCalculated[currentHouse] != -1) {
            return alreadyCalculated[currentHouse];
        }
        int robCurrentHouse = nums[currentHouse] + helper(currentHouse + 2, totalHouses, nums, alreadyCalculated);
        int skipCurrentHouse = helper(currentHouse + 1, totalHouses, nums, alreadyCalculated);
        int maxCoins = Math.max(robCurrentHouse, skipCurrentHouse);
        
        alreadyCalculated[currentHouse] = maxCoins;
        return maxCoins;
    }
    
    
    public int rob(int[] nums) {
        int totalHouses = nums.length;
        int[] alreadyCalculated = new int[totalHouses];
        Arrays.fill(alreadyCalculated, -1);
        return helper(0, totalHouses, nums, alreadyCalculated);
    }
}