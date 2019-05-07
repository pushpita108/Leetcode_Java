class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for( int i=0; i<prices.length; i++){
            if( prices[i] < minPrice){ // keep updating minPrice
                minPrice = prices[i];
            }else if( prices[i]-minPrice > maxProfit ){ // if we do not hit a min price, calculate profit and keep only the max till now 
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}