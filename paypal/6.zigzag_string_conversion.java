class Solution {
    public String convert(String s, int numRows) {
        
        if( numRows == 0 ) return "";
        if( numRows == 1 ) return s;
        
        Character[][] store = new Character[numRows][s.length()];
        int r=0;
        int c=0;
        
        int i=0;
        while( i<s.length() ){

            while( r < numRows && i<s.length() ){ // fill vertically 
                store[r][c] = s.charAt(i);
                i++;
                r++;
            }
            
            r--; // revert the last extra
            while( r-1 > 0 && i<s.length() ) { //fill obliquely backwards
                store[--r][++c] = s.charAt(i);
                i++;
            }
            r--;c++; // revert the last extra
        }
        
        StringBuilder sb = new StringBuilder();
        for( int a=0; a<store.length; a++){
            for( int b=0; b<store[0].length; b++){
                if( store[a][b] != null )
                    sb.append( store[a][b]);
            }
        }
        return sb.toString();
    }
}