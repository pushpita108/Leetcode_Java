class Solution {
    public int calculate(String s) {
        
        if( s==null || s.length() < 1) return Integer.MIN_VALUE;
        return evaluateSuffix( convertToSuffix(s) );
        
    }
    
    public List<Object> convertToSuffix(String s){
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        List<Object> list = new ArrayList<>();
        
        int num=0;
        boolean gotNum = false;
        
        for( char c : s.toCharArray() ){
            
            if( isNumber(c) ){
                num = num*10 + (c-'0');
                gotNum = true;
            }else{ // now we have the whole number like 256+32 , 256 or 32 
                if( gotNum ) {
                    list.add( num ); 
                    num = 0;
                    gotNum = false;
                }
                
                // now put operator checks
                if( c == ' ' || c == '\t' ) continue;
                if( c == '(' ) stack.push(c);
                else if( c == ')' ) {
                    while( stack.peek() != '(' ) list.add( stack.pop() );
                    stack.pop(); // pop the ( also
                }else{
                    while( !stack.isEmpty() && rank(c) <= rank( stack.peek() ) ) list.add( stack.pop() );
                    stack.push(c);
                }
                //done
            }
        }
        
        //Final checks 
        if( gotNum ) list.add( num ); 
        while( !stack.isEmpty() ) list.add( stack.pop() );
        return list;
    }
    
    public int evaluateSuffix(List<Object> list){
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int operand1, operand2;
        
        for( Object o : list ){
            
            if( o instanceof Integer ){
                stack.push( (Integer)o );
            }else{
                char operator = (Character)o;
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch( operator ){
                    case '+' : stack.push( operand1 + operand2 ); break;
                    case '-' : stack.push( operand1 - operand2 ); break;
                }
            }
        }
        
        return stack.pop();
    }
    
    public int rank(char c){
        switch(c){
            case '+' : return 1;
            case '-' : return 1;
            default : return 0; // for ( )
        }
    }
    
    public boolean isNumber(char c){
        if ( c - '0' >= 0 && c - '0' <= 9) return true;
        else return false;
    }
}