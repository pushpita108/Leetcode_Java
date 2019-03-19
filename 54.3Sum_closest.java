class Solution {
    public int threeSumClosest(int[] nums, int target) {
     
        Arrays.sort(nums);
        
        //int result = Integer.MAX_VALUE; // overflow can happen
        // so 
        int result = nums[0] + nums[1] + nums[2];
        
        for( int i=0; i<nums.length; i++){

            int left = i+1 ; 
            int right = nums.length-1; 
            while( left < right ){
                int sum = nums[i] + nums[left] + nums[right];
                if( sum < target ){
                    left++;
                }else if( sum > target){
                    right--;
                }else{
                    return sum;
                }
                if( Math.abs(sum-target) < Math.abs(result-target) ) //special check diff from 3sum
                    result = sum;
            }
        }
        return result;
    }
}