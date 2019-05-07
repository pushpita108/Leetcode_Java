class Solution {
    public int removeElement(int[] nums, int val) {
        
        int i=0; // position to enter next element
        
        for(int j=0; j<nums.length; j++){
            if( nums[j] != val ){  // check when not equals, then replace
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}