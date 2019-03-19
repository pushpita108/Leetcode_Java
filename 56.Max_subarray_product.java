class Solution {
    public int maxProduct(int[] nums) {
        
        
        if (nums == null || nums.length == 0) return 0;
    
        int result = nums[0];
        
        
        // we need to arrays here to handle -ve*-ve case 
        int[] maxSubArr = new int[nums.length]; // as 6*-2 < -6*-2
        int[] minSubArr = new int[nums.length]; // as -6*-2 > 4*-2
        
        maxSubArr[0] = nums[0];
        minSubArr[0] = nums[0];
        
        for( int i=1; i<nums.length; i++){
            maxSubArr[i] = Math.max(Math.max( maxSubArr[i-1]*nums[i] , minSubArr[i-1]*nums[i] ) , nums[i]); 
            minSubArr[i] = Math.min(Math.min( maxSubArr[i-1]*nums[i] , minSubArr[i-1]*nums[i] ) , nums[i]); 
            result = Math.max( result, maxSubArr[i]);
        }
        
        return result;
    }
}
