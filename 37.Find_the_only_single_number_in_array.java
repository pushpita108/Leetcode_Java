class Solution {
    public int singleNumber(int[] nums) {

        int result = 0;
        for( int i : nums){
            result ^= i;
        }
        return result;
    }
}
// This solution wont work for { 0, 1, 1, 2} or { 1, 1, 1, 2}
/////////////////////////////////////////////////////////////////////


class Solution {
    public int singleNumber(int[] nums) {
        int result=-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i : nums ){
            if( map.containsKey(i)){
                map.put( i , map.get(i)+1) ;
            } else {
                map.put(i,0);
            }
        }
        
        for(int i : map.keySet() ){
            if( map.get(i) == 0)
                result = i;
        }
        return result;
    }
}