



///////////////////////////////  above nlogn,  ---  below n^2 ////////////////////// 

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        int result = 1;
        for(int i=1; i<nums.length; i++){
            int max = 0;
            for( int j=0; j<i; j++){ // find the max from 0 uptil this loc
                if(nums[i] > nums[j]) { // trying to add i into every sequence possible before it
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max+1; // set the max at this loc 
            result = Math.max( dp[i], result ); // to avoid 2nd pass 
        }
        return result;
    }
}