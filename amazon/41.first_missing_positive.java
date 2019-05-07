class Solution {
    public int firstMissingPositive(int[] A) {
        
        // idea is that the first missing positive will fall between 0 and nums.length + 1
        
        // put every element of array to its corresponsding index
        
        // ignore negatives 
        
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1); // check if not case [1,1,1]
            else i++;
        }
        
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        
        return i+1;
    }
    
    public void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}