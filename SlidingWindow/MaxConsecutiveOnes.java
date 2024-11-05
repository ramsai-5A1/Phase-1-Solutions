/**
 * One-Pass Optimized Sliding Window
 *
 * If A[start] ~ A[end] has zeros <= K, we continue to increment end.
 * (Reason: The window is still valid and window size can be increased.)
 *
 * If A[start] ~ A[end] has zeros > K, we increment both start & end.
 * (Reason: The window contains extra zeros thus it is not valid any more, and we
 * will increment both start & end to keep the window size same.)
 *
 * Time Complexity: O(N)
 *
 * Space Complexity: O(1)
 *
 * N = Length of the input array
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int start = 0;
        int end = 0;
        int zeros = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }
            end++;
            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }

        return end - start;
    }
}