class Solution { //o(n) o(n)
    public int findPairs(int[] nums, int k) {

        if( k < 0 ) return 0; // corner case 
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for( int i : nums ){
            map.put( i, map.getOrDefault(i,0) + 1 );
        }
        
        int result = 0;
        
        if( k == 0){ // count repeats
            for( int i : map.keySet() ){
                if( map.get(i) > 1){
                    //result += (map.get(i)/2 ); // implicit conversion to int for ceil
                    result++; // as per question
                }
            }
        }else{
            for( int i : map.keySet() ){
                if( map.containsKey( i+k ) ){
                    result++;
                }
            }
        }
        return result;
    }
}