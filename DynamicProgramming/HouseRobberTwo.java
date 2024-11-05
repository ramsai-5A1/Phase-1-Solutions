class Solution {

    private int topToBottom(int[] nums, int index, int N, int[] cache) {
        if (index >= N) {
            return 0;
        } else if (cache[index] != -1) {
            return cache[index];
        }
        int takeCurrentHouse = topToBottom(nums, index + 2, N, cache) + nums[index];
        int skipCurrentHouse = topToBottom(nums, index + 1, N, cache);
        cache[index] =  Math.max(takeCurrentHouse, skipCurrentHouse);
        return cache[index];
    }

    private int bottomToTop(int[] nums, int startIndex, int N, int[] cache) {
        cache[N - 1] = nums[N - 1];
        cache[N - 2] = Math.max(nums[N - 2], nums[N - 1]);

        for (int index = N - 3; index >= startIndex; index--) {
            int takeCurrentHouse = cache[index + 2] + nums[index];
            int skipCurrentHouse = cache[index + 1];
            cache[index] =  Math.max(takeCurrentHouse, skipCurrentHouse);
        }
        return cache[startIndex];
    }

    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        } else if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] cache = new int[N];

        Arrays.fill(cache, -1);
        //int startFromFirstHouse = topToBottom(nums, 0, N - 1, cache);
        int startFromFirstHouse = bottomToTop(nums, 0, N - 1, cache);

        Arrays.fill(cache, -1);
        //int startFromSecondHouse = topToBottom(nums, 1, N, cache);
        int startFromSecondHouse = bottomToTop(nums, 1, N, cache);
        return Math.max(startFromFirstHouse, startFromSecondHouse);
    }
}