

// User function Template for Java

class Solution {
    static int mod = (int) 1e9 + 7;
    
    static long topDownHelper(int n, long[] cache) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (cache[n] != -1) {
            return cache[n];
        }
        
        cache[n] = (topDownHelper(n - 1, cache) + topDownHelper(n - 2, cache)) % mod;
        return cache[n];
    }
    
    static long topDown(int n) {
        
        long[] cache = new long[n + 1];
        Arrays.fill(cache, -1L);
        return topDownHelper(n, cache);
    }

    static long bottomUp(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;
        
        for (int index = 2; index < n; index++) {
            arr[index] = (arr[index - 1] + arr[index - 2]) % mod;
        }
        return arr[n - 1];
    }
}