import java.lang.Math;

class Solution {
    public int findMin(int[] nums) {

        //log(n)
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.min(nums[0],nums[1]);
        int left = 0; 
        int right=nums.length-1;
        int mid;
        while(left <= right) {
            mid = (left + right)/2;
            if( mid>0 && nums[mid] < nums[mid-1]){ // important conditon!!!
                return nums[mid];
            } else if( nums[mid] < nums[0]) { // second part of array 
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return nums[0];
    }

    public static void main(String args[]){
        int a[] = { 3, 1, 2};
        Solution s = new Solution();
        System.out.println(s.findMin(a));
    }
}