/**
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = m-1;
        int j = n-1;
        
        int index = nums1.length - 1;
        
        // start from back
        
        while( i >= 0 && j >= 0 ){
            nums1[index] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            index--;            
        }
        
        // copy the extra items from array 2 in case array 1 has no elements initialized 
        System.arraycopy( nums2, 0, nums1, 0, j+1 );
    }
}