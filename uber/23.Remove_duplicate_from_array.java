class Solution {
    public int removeDuplicates(int[] nums) {
        
        int insertAt = 0;
        int curr = 0;
        int max = nums.length;
        
        while( curr < max ){
            while( curr > 0 && curr < max && nums[curr] == nums[curr-1] ){
                curr++;
            }
            if( curr < max ){
                nums[insertAt++] = nums[curr++];
            }
        }
        return insertAt; 
    }
}