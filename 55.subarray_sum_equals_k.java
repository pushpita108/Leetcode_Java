class Solution {
    public int subarraySum(int[] nums, int k) {
        
        // get the cumulative sums
        // store the cumulative sums in a hashmap 
        // hashmap has cumulative sum , count( so that same sum is not read more than number of times it is present)
        // now subarray of sum k => cumsum[j] - cumsum[i] = k 
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int result = 0;
        map.put(0,1); // for subarrays whose sum is k directly
        
        for( int i=0; i< nums.length; i++ ){
            sum = sum + nums[i]; // cum sum 

            if( map.containsKey( sum - k ) ){ // if teh complement is in map, add to count 
                result += map.get( sum - k );
            }
            
            // This is second after checking sum in map, as if we add 1 and are searching for 1, the same element gets counted
            map.put(sum, map.getOrDefault(sum, 0)+1 ); // add to map, increase count
        }
        return result;
    }
}