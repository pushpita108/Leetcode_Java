class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if( s.length() != t.length() ) return false;
        
        // map to map chars from string 1 to string 2
        HashMap<Character,Character> map = new HashMap();
        HashMap<Character,Character> map2 = new HashMap();
        
        for( int i=0; i<s.length(); i++){
            
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            // on first encounter put in map  &&  if b is not already ampped to soemthing else
            if( !map.containsKey(a)){
                map.put( a, b);
            } else {
                // on next encounters check if equality with second string
                if( map.get(a) != b){
                    return false;
                }
            }
            
            //Same for second map
            if( !map2.containsKey(b)){
                map2.put( b, a);
            } else {
                if( map2.get(b) != a){
                    return false;
                }
            }
        }
        // everything ok
        return true;
        
    }
}