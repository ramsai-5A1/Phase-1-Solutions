class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        // 10, 1, 2, 3, 100
        Stack<Integer> stack = new Stack<>();
        for (int index = n - 1; index >= 0; index--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[index]) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result[index] = stack.peek() - index;
            }
            
            stack.push(index);
        }
        
        return result;
    }
}