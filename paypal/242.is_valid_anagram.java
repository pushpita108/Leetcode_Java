class Solution { //o(1) space // o(s+t+26) time
    public boolean isAnagram(String s, String t) {
        
        int[] count = new int[26]; // 26 alphabets
        
        for( char c : s.toCharArray() ){
            count[ c-'a' ]++;
        }
        
        for( char c : t.toCharArray() ){
            count [ c-'a' ]--;
        }
        
        for( int i : count ){
            if( i != 0 ) return false;
        }
        return true;
        
    }
}