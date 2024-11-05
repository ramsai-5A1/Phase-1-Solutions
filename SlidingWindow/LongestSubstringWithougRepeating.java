class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> store = new HashMap();
        int n = s.length();

        int left = 0, right = 0, result = 0;
        while (right < n) {
            if (store.containsKey(s.charAt(right))) {
                left = Math.max(left, store.get(s.charAt(right)) + 1);
            }
            store.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}