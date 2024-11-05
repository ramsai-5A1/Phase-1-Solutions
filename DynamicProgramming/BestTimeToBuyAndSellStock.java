class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0, costPrice = prices[0];

        for (int price: prices) {
            costPrice = Math.min(price, costPrice);
            result = Math.max(result, price - costPrice);
        }
        return result;
    }
}