class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int min = prices[0];
        int profit = 0;
        for(int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price-min);
        }
        return profit;
    }
}