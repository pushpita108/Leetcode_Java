class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> result = new ArrayList<>();
        
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put( 3, "Fizz");
        map.put( 5, "Buzz");
    
        if( n >= 1 ) result.add("1");
        
        for( int i=2; i<=n; i++){
            StringBuilder res = new StringBuilder();
            for( int j : map.keySet() ){
                if( i%j == 0 ) res.append( map.get(j) );
            }
            if( res.toString().equals("") ) res.append(""+i);
            result.add(res.toString());
        }
        return result;
    }
}