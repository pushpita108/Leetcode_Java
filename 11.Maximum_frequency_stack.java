class FreqStack {
    //value and count 
    HashMap<Integer, Integer> valCount = new HashMap();

    // count and stack of values
    HashMap<Integer, Stack<Integer>> countValStack = new HashMap();

    //max freq at given point of time
    int maxFreq = 0;

    public FreqStack() {
    }
    
    public void push(int x) {
        //add to valCount map and update maxFreq
        int count;
        if( valCount.containsKey(x) ){
            int newCount = valCount.get(x)+1;
            valCount.put( x,  newCount);
            maxFreq = Math.max(maxFreq, newCount);
            count = newCount;
        }else {
            valCount.put( x, 1 );
            count = 1;
        }
        
        //update countValStack map
        if( countValStack.containsKey(count)){
            countValStack.get(count).push(x);
        } else {
            Stack<Integer> ns = new Stack();
            ns.push(x);
            countValStack.put(count, ns);
        }
        
        
    }
    
    public int pop() {
        if( valCount.size() == 0 ){
            return -1;
        }
        
        int result = countValStack.get(maxFreq).pop();
        if( countValStack.get(maxFreq).size() == 0){
            maxFreq--;
        }
        valCount.put( result, valCount.get(result)-1 );
        return result;
                
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */