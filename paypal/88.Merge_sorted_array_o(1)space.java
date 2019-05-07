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
        
        System.arraycopy( nums2, 0, nums1, 0, j+1 ); // copy the extra items from array 2 in case array 1 has no elements initialized 
        // for case when array 1 is empty
        
    }
}