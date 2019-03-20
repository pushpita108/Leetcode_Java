/**
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.
*/

class Solution{
  
  public int[] nextGreater( int[] arr ) {
    
    int[] result = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    
    for( int i= arr.length-1; i>=0; i--){
    
          while( stack.empty() && stack.peek() <= arr[i] ){ // at every place pop put all elements less than curr to get the first greater element in right
              stack.pop();
          }

          result[i] = stack.empty() ? -1 : stack.peek();
          stack.push(arr[i]); // keep pushing every element
    }
    
    return result;
    
  }
 

}
