class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();
        backtrack( n, "", 0, 0, result);
        return result;
     }
    
    public void backtrack( int n, String s, int open, int close, List<String> result ){
        if( s.length() == n*2 ){
            System.out.println(s);
            result.add(s);
            return;
        }
        
        if( open < n ){
            System.out.println(s+"(");
            backtrack( n, s+"(", open+1, close, result);
        }
        if( close < open ){
            System.out.println(s+")");
            backtrack( n, s+")", open, close+1, result);
        }
    }
}