class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = binarySearchFirstOcc(nums, target);
        if( left == -1) return new int[] {-1,-1};
        int right = left;
        while( right < nums.length && nums[right] == target  ){
            right++;
        }
        return new int[] {left, right-1};
        
    }
    
    public int binarySearchFirstOcc(int[] nums, int target){
        
        int low = 0, high = nums.length; //important
        int mid;
        while( low < high ){ //important
            mid = ( low + high ) / 2;
            if( nums[mid] == target && (mid==0 || (nums[mid] != nums[mid-1]))) //important
                return mid;
            else if( nums[mid] < target)
                low = mid + 1;
            else 
                high = mid;//important
        }
        return -1;
    }
}