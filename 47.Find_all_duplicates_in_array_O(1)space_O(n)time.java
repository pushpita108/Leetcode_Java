class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        //Numbers in the array are in range 1-N 
        // so, make the number at index a[i] = -a[i] when its first encountered
        // if we encounter -ve in the array later on, then its a duplicate 
        
        List<Integer> result = new LinkedList<>();
        
        for( int i=0; i<nums.length; i++){
            
            int indexToDeal = Math.abs( nums[i] ) - 1; // to avoid array out of bounds 
            if( nums[indexToDeal] < 0) {
                result.add( indexToDeal + 1 );
            } else {
                nums[ indexToDeal ] = -nums[ indexToDeal ];
            }
        }
        return result;
    }
}