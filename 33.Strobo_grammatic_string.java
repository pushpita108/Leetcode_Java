class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper( n, n );
    }
    
    public List<String> helper(int n, int max){
        
        //base cases 
        if( n==0 ) return Arrays.asList("");
        if( n==1 ) return Arrays.asList("0", "1", "8");
        
        // create the variables 
        List<String> result = new ArrayList<>();
        List<String> temp;
        
        //recurse
        temp = helper( n-2, max );
        
        //Attach things 
        for( String s : temp ){
            if( n != max ){
                result.add( "0" + s + "0" );
            }
            result.add( "1" + s + "1" );
            result.add( "8" + s + "8" );
            result.add( "6" + s + "9" );
            result.add( "9" + s + "6" );
        }
        
        return result;
    }
}