class Solution {
    public void nextPermutation(int[] nums) {
        
        //4 steps 
        // find first decreasing ele =  x
        // find number greater than x =  y
        // swap x and y
        // reverse position of x to end 
        
        int x, y;
        for(x=nums.length-2; x>=0; x--){
            if(nums[x] < nums[x+1]) {
                break;
            }
        }
        
        if( x >= 0) { // if not in complete descending order 
            // right side is already sorted in decreasing order 
            // so to get the next largest element, we can find the first ele > x from right
            for(y=nums.length-1; y>x; y--){
                if( nums[y] > nums[x] ){
                    break;
                }
            }
            swap(nums, x, y);
        }
        
        reverse(nums, x+1, nums.length-1);
    }
    
    public void reverse(int[] nums, int x, int y){
        while( x < y ){
            swap(nums, x, y);
            x++;
            y--;
        }
    }
    
    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}