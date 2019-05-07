class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> result = new ArrayList<>();
        
        int[] ends = new int[26];
        for( int i=0; i<S.length(); i++){ // get the last occurences of every letter 
            char c = S.charAt(i);
            ends[c - 'a'] = i;
        }
        
        int boundary = 0;
        int count = 0;
        for( int i=0; i<S.length(); i++){ 
            boundary = Math.max( boundary, ends[S.charAt(i)-'a'] ); // update boundary first 
            count++;
            if( i == boundary ){ // if we reached boundary, add to answer 
                result.add( count );
                count = 0;
            }
        }
        return result;
        
    }
}