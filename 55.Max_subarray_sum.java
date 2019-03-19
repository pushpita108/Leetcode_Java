class Solution {
    public int maxSubArray(int[] nums) {
        
        // brute force O(n3) -> start from every i and go till every j to find sum at each step 
        // O(n2) + O(n) space -> start from every i and go till every j>i, saving the prob solved till before in extra space 
        
        // O(n) -> dynamic programming 
        // Max that can be acheived at index i = 
        //          max that can be acheived at index i-1 or start new sub array from i 
        
//         int result = nums[0];
        
//         int[] maxSubArr = new int[nums.length];
//         maxSubArr[0] = nums[0];
        
//         for( int i=1; i<nums.length; i++){
//             maxSubArr[i] = Math.max( maxSubArr[i-1]+nums[i] , nums[i] ); // as there will be negative nums also 
//             result = Math.max( result, maxSubArr[i]);
//         }
        
//         return result;
        
        int result = nums[0];
        
        //As we only need n-1, no need of extra space
        int prev = nums[0];
        
        for( int i=1; i<nums.length; i++){
            int curr = Math.max( prev + nums[i] , nums[i] ); // as there will be negative nums also 
            prev = curr;
            result = Math.max( result, curr );
        }
        
        return result;
        
    }
}