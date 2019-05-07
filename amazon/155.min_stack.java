class MinStack {

    int min;
    Stack<Integer> s = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        //if new elemnt changes the min, then old min and then push new element
        if( x <= min ) { // checking = also as we need to insert twice for cases where new element=min
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        //Now if we are popping the current min, it means we need to switch back to old min which lies in next pop 
        if( s.pop() == min ){
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}

// Another Approach 
// use a node class with val,next,min and use it in a linked list 

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */