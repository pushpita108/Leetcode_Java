class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new LinkedList<>();
        if( s==null || words==null || words.length==0 ) return result;
        
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        
        int len = words[0].length();
        int n = words.length;
        
        
        for(int i=0; i<= s.length()-(len*n) ; i++){ // <= and ++ important ( can't do +=len as lllfoobar is also a valid string and we have to check uptil = to that length )
            
            String word = s.substring(i, i+len);
            // System.out.println(word);
            if( map.containsKey(word) ){ // start search
                
                Map<String, Integer> curr = new HashMap<>();
                for( int j=0; j<n; j++){ // we have to find n words in total
                    
                    String word2 = s.substring( i+j*len , i+(j+1)*len );
                    if( map.containsKey(word2) ){
                        curr.put(word2, curr.getOrDefault(word2, 0)+1);
                        if( curr.get(word2) > map.get(word2) ){
                            break; // more number of occurences 
                        }
                    }else {
                        break; //intervening word
                    } 
                }
                if( map.equals(curr) ) result.add(i);
            }
        }
        return result;
    }
}