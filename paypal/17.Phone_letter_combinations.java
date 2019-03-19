class Solution {
    public List<String> letterCombinations(String digits) {
    
        Queue<String> result = new LinkedList<String>();
        String[] mappings = { "0" , "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
        if( digits.length() == 0) return (List)result;// corner case

        //Queue for processing
        result.add(""); // to avoid null pointer 

        while( result.peek().length() != digits.length()){ //smart
            
            int digit = digits.charAt( result.peek().length() ) - '0'; //smart
            
            String prev = result.remove();
            for( char c : mappings[digit].toCharArray() ){
                result.add( prev + c );
            } 
        }
        return (List)result; // rememebr this
    }
}