
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> result = new HashMap<>();
        //form a string of char counts, ex : 2#3#0#0#1#....#
        for( String s : strs ){
            char[] chars =  s.toCharArray();
            Arrays.sort( chars );
            String sortedStr = new String( chars );
            if( !result.containsKey(sortedStr)){
                result.put(sortedStr, new ArrayList<String>());
            }
            result.get(sortedStr).add(s);
        }

        return new ArrayList(result.values());
    }
}



//////////////////////////////////////////////////////////////////////
//Above solution has better time complexity 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        // int[][] charCounts = new int[strs.length][26];
        
        // // get all the char counts
        // for( int i=0; i<strs.length; i++){
        //     for( char c : strs[i].toCharArray() ){
        //         charCounts[i][c - 'a']++;
        //     }
        // }
        
        HashMap<String, List<String>> result = new HashMap<>();
        //form a string of char counts, ex : 2#3#0#0#1#....#
        for( int i=0; i<strs.length; i++){

            int[] charCounts = new int[26];
            for( char c : strs[i].toCharArray() ){
                charCounts[ c - 'a']++;
            }

            String modified = "";
            for( int j=0; j<26; j++){
                modified += charCounts[j] + "#" ;
            }
            if( !result.containsKey(modified)){
                result.put(modified, new ArrayList<String>());
            }
            result.get(modified).add(strs[i]);
        }
        
        return new ArrayList(result.values());
    }
}


////////////////////////////////////////////////////////////////////////////
//Above solution has better space complexity 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int[][] charCounts = new int[strs.length][26];
        
        // get all the char counts
        for( int i=0; i<strs.length; i++){
            for( char c : strs[i].toCharArray() ){
                charCounts[i][c - 'a']++;
            }
        }
        
        HashMap<String, List<String>> result = new HashMap<>();
        //form a string of char counts, ex : 2#3#0#0#1#....#
        for( int i=0; i<strs.length; i++){
            String modified = "";
            for( int j=0; j<26; j++){
                modified += charCounts[i][j] + "#" ;
            }
            if( !result.containsKey(modified)){
                result.put(modified, new ArrayList<String>());
            }
            result.get(modified).add(strs[i]);
        }
        
        return new ArrayList(result.values());
    }
}