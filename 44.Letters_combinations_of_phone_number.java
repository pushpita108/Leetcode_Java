
class Solution {
    public List<String> letterCombinations(String digits) {
    
        Queue<String> result = new LinkedList<String>();
        String[] mappings = { "0" , "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
        if( digits.length() == 0) return (List)result;// corner case
        //Queue for processing
        result.add(""); // to avoid null pointer 
        while( result.peek().length() != digits.length()){ //smart
            
            int digit = digits.charAt( result.peek().length()) - '0'; //smart
            
            String prev = result.remove();
            for( char c : mappings[digit].toCharArray() ){
                result.add( prev + c );
            } 
        }
        return (List)result; // rememebr this
    }
}


/////// cleaner above ////////////////


class Solution {
    public List<String> letterCombinations(String digits) {
        // Queue - string length - combinations 
        LinkedList<String> res = new LinkedList<>();
        if(digits.isEmpty()) return res;
        String[] mappings = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        while( res.peek().length() != digits.length() ){
            int digit = digits.charAt(res.peek().length())-'0';
            String val = mappings[digit];
            //System.out.println(val);
            String base = res.remove();
            for(char c: val.toCharArray()){
                res.addLast(base + c);
                //System.out.println(base+c);
            }
        }

        return res;
    }
}