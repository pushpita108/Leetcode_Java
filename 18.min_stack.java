//Another way is to have a linkedlist with min and val in each node

class MinStack {

    int min;
    Stack<Integer> s = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        //if new elemnt changes the min, then old min and then push new element
        if( x < min || x < s.peek()) {
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */