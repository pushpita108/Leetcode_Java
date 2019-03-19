class Solution {
    public int findPairs(int[] nums, int k) {
        
        int result = 0;
        if ( k < 0 ) return result; // corner case, as k is absolute difference
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i : nums ){
            map.put( i, map.getOrDefault(i, 0)+1 );
        }// got the counts
        
        for( int i : map.keySet() ){
            int otherNum = i + k ;
            if( k==0 ){
                if( map.get(otherNum) >= 2){
                    System.out.println("here " + i + ", " + otherNum);
                    result++;
                }
            }else{
                if( map.containsKey(otherNum) ) {
                    System.out.println("here2 " + i + ", " + otherNum);
                    result++;
                }
            }
        }
        
        return result;
    }
}